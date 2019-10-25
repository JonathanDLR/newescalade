package org.escalade.webapp.servlets;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.escalade.model.beans.Cotation;
import org.escalade.model.beans.Lieu;
import org.escalade.model.beans.Site;
import org.escalade.webapp.resources.AbstractResource;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Servlet implementation class NewSiteServlet
 */
@Controller
@RequestMapping("/newsite")
public class NewsiteServlet extends AbstractResource {  
	/**
	 * Sending the new site view
	 * @param session get the connected user
	 * @param model pass the form to create site
	 * @return
	 */
    @RequestMapping(method = RequestMethod.GET)
 	public String display(HttpSession session, Model model) {
    	if (session.getAttribute("user") != null) {
    		// GET THE LIEU
    		List<Lieu> lieus = getManagerFactory().getLieuManager().getAllLieus();
    		session.setAttribute("lieus", lieus);
    		
    		// GET THE COT
    		List<Cotation> cotations = getManagerFactory().getCotationManager().getAllCotation();
    		session.setAttribute("cotations", cotations);
    		
    		Site site = new Site();
    		model.addAttribute("siteForm", site);
    		
    		return "newsite";
    	} else {
    		return "accounterror";
    	}
 	}
    
    /**
     * Creating site form form info
     * @param pSite The site created
     * @param br
     * @param model send OK message
     * @param session
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String createSiteFormForm(@Valid @ModelAttribute("siteForm") Site pSite, BindingResult br, Model model,
    		HttpSession session) {
    	if (session.getAttribute("user") != null) {
    		Site site = getManagerFactory().getSiteManager().getSiteByNom(pSite.getNom());
        	  	
        	// CHECK INFO BEFORE INJECTING IN DB
        	if (br.hasErrors()) {    		
        		return "newsite";
        	} else if (site != null) {
        		br.rejectValue("nom", "error.siteNotUnique", "Un site avec ce nom existe déjà.");
        		
        		return "newsite";
        	} 
       
        	else {
        		// SANITIZE INPUT VALUE
        		PolicyFactory sanitizer = new HtmlPolicyBuilder().toFactory();
        		String pNom = sanitizer.sanitize(pSite.getNom());
        		
        		// CREATING TOPO
            	getManagerFactory().getSiteManager().createSite(pSite, pNom);
            
            	
            	model.addAttribute("rep", "Votre site a bien été créé.");
            	return "newsite";
        	}
    	} else {
    		return "accounterror";
    	}
    }
}
