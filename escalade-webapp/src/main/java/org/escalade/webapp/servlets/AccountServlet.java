package org.escalade.webapp.servlets;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.escalade.model.beans.Lieu;
import org.escalade.model.beans.Topo;
import org.escalade.model.beans.User;
import org.escalade.webapp.resources.AbstractResource;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Servlet implementation class InscriptionServlet
 */
@Controller
public class AccountServlet extends AbstractResource {   
    @RequestMapping(value="/account", method = RequestMethod.GET)
 	public String display(HttpSession session, Model model) {
    	if (session.getAttribute("user") != null) {
    		List<Lieu> lieus = getManagerFactory().getLieuManager().getAllLieus();
    		Topo topo = new Topo();
    		
    		model.addAttribute("topoForm", topo);   		
    		session.setAttribute("lieus", lieus);
    		
    		return "account";
    	} else {
    		return "accounterror";
    	}
 	}
    
    @RequestMapping(value="/account", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String createTopoFromForm(@Valid @ModelAttribute("topoForm") Topo pTopo, BindingResult br, Model model,
    		HttpSession session) throws ParseException {  
    	
    	if (session.getAttribute("user") != null) {
    		Topo topo = getManagerFactory().getTopoManager().getTopoByName(pTopo.getName());
        	System.out.print(pTopo.getDescription());
        	
        	
        	// CHECK INFO BEFORE INJECTING IN DB
        	if (br.hasErrors()) {    		
        		return "account";
        	} else if (topo != null) {
        		br.rejectValue("name", "error.topoNotUnique", "Un topo avec ce nom existe déjà.");
        		
        		return "account";
        	} 
       
        	else {
        		PolicyFactory sanitizer = new HtmlPolicyBuilder().toFactory();
        		
        		pTopo.setName(sanitizer.sanitize(pTopo.getName()));
        		pTopo.setDescription(sanitizer.sanitize(pTopo.getDescription()));
        		pTopo.setUser((User) session.getAttribute("user"));
            	getManagerFactory().getTopoManager().createTopo(pTopo);
            	
            	model.addAttribute("rep", "Votre topo a bien été créé.");
            	return "account";
        	}
    	} else {
    		return "accounterror";
    	}
    	
    }
    
    @ResponseBody
    @RequestMapping(value = "/newlieu", method = RequestMethod.POST)
    public String newlieu(@RequestParam("newlieu") String newlieu) {
    	PolicyFactory sanitizer = new HtmlPolicyBuilder().toFactory();
    	
    	// Creating the new lieu
    	Lieu newLieu = new Lieu();
    	newLieu.setName(sanitizer.sanitize(newlieu));
    	// Creating the new lieu
    	getManagerFactory().getLieuManager().createLieu(newLieu);
    	
    	// Sending all the lieu to jsp
    	List<Lieu> lieus = getManagerFactory().getLieuManager().getAllLieus();
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	
    	return gson.toJson(lieus);
    }
}
