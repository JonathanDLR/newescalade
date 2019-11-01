package org.escalade.webapp.servlets;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.escalade.model.beans.Commentaire;
import org.escalade.model.beans.Cotation;
import org.escalade.model.beans.Lieu;
import org.escalade.model.beans.Site;
import org.escalade.model.beans.User;
import org.escalade.webapp.resources.AbstractResource;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class SiteServlet
 */
@Controller
public class SiteServlet extends AbstractResource {
	Lieu pLieu = null;
	Cotation pCot = null;
	int pSecteur = 0;

	/**
	 * Display the view
	 * @param session inject the list of infos for the searchng
	 * @return
	 */
	@RequestMapping(value = "/site", method = RequestMethod.GET)
	public String display(HttpSession session) {
		pLieu = null;
		pCot = null;
		pSecteur = 0;
			
	   	// GET THE SITE
		List<Site> sites = getManagerFactory().getSiteManager().getAllSite(pLieu, pCot, pSecteur);
	   	session.setAttribute("sites", sites);
	   		
	   	// GET INFO FOR THE SEARCHING
	   	List<Lieu> lieus = getManagerFactory().getLieuManager().getAllLieus();
	   	session.setAttribute("lieus", lieus);
	   	List<Cotation> cotations = getManagerFactory().getCotationManager().getAllCotation();
	   	session.setAttribute("cotations", cotations);
	    		   		
	   	return "sites";
	}

	/**
	 * Searching sites with params
	 * @param lieu
	 * @param cotation
	 * @param secteur
	 * @param session updating the sites in session
	 * @return
	 */
	@RequestMapping(value ="/search", method = RequestMethod.POST)
	public String search(@RequestParam("lieu") String lieu, @RequestParam("cotation") String cotation,
				@RequestParam("secteur") String secteur, HttpSession session) {
		pLieu = getManagerFactory().getLieuManager().getLieuByName(lieu);
		pCot = getManagerFactory().getCotationManager().getCotationByCot(cotation);
		if (secteur != "") {
			pSecteur = Integer.parseInt(secteur);
		} else {
			pSecteur = 0;
		}
		
		
		// Sending all the sites to jsp with JSON
    	List<Site> sites = getManagerFactory().getSiteManager().getAllSite(pLieu, pCot, pSecteur);
    	session.setAttribute("sites", sites);
    	
    	return "sites";
	}
	
	@ResponseBody
	@RequestMapping(value = "/togglesite", method = RequestMethod.POST)
	public void toggleSite(@RequestParam("site") String site) {
		Site pSite = getManagerFactory().getSiteManager().getSiteByNom(site);
		getManagerFactory().getSiteManager().toggleOfficial(pSite);
	}
	
	/**
	 * Creating new Com
	 * @param com the new com
	 * @param site concerned
	 * @param session getting the user of the com
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/createcom", method = RequestMethod.POST)
	public String createCom(@RequestParam("com") String com, @RequestParam("site") String site, HttpSession session) {
		// Sanitize value
		PolicyFactory sanitizer = new HtmlPolicyBuilder().toFactory();
		String newCom = sanitizer.sanitize(com);
				
		Site newSite = getManagerFactory().getSiteManager().getSiteByNom(site);
		User user = (User) session.getAttribute("user");
		int newId = getManagerFactory().getCommentaireManager().createCom(new Commentaire(), newCom, newSite, user);
		
		
		
		// Set the ajax response to rebuild html
		String[] response = {user.getPseudo(), user.getRole().getName(), Integer.toString(newId)};
		
		final GsonBuilder builder = new GsonBuilder();
	    final Gson gson = builder.create();
	    
		return gson.toJson(response);
	}
	
	/**
	 * Updating com
	 * @param comToUpdate the com to update
	 * @param newCom the new com
	 */
	@ResponseBody
	@RequestMapping(value="/updcom", method = RequestMethod.POST)
	public void updateCom(@RequestParam("comToUpdate") String comToUpdate, @RequestParam("newCom") String newCom) {
		Commentaire pCommentaire = getManagerFactory().getCommentaireManager().getCommentaireById(Integer.parseInt(comToUpdate));
		
		// Sanitize value
		PolicyFactory sanitizer = new HtmlPolicyBuilder().toFactory();
		String newComSanitized = sanitizer.sanitize(newCom);
		
		getManagerFactory().getCommentaireManager().updateCom(pCommentaire, newComSanitized);
	}
	
	/**
	 * Deleting com
	 * @param comToDelete
	 */
	@ResponseBody
	@RequestMapping(value="/delcom", method = RequestMethod.POST)
	public void deleteCom(@RequestParam("comToDelete") String comToDelete) {
		getManagerFactory().getCommentaireManager().deleteCom(Integer.parseInt(comToDelete));
	}
}
