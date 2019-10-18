package org.escalade.webapp.servlets;


import javax.servlet.http.HttpSession;

import org.escalade.webapp.resources.AbstractResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Servlet implementation class InscriptionServlet
 */
@Controller
@RequestMapping("/deco")
public class DeconnexionServlet extends AbstractResource {

       
    @RequestMapping(method = RequestMethod.GET)
 	public String display(HttpSession session) {
    	if (session.getAttribute("user") != null) {
    		session.invalidate();
    		return "accueil";
    	} else {
    		return "accueil";
    	}
 	}
}
