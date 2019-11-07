package org.escalade.webapp.servlets;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Servlet implementation class InscriptionSuccessServlet
 */
@Controller
@RequestMapping("/inscriptionsuccess")
public class InscriptionSuccessServlet {       
	@RequestMapping(method = RequestMethod.GET)
 	public String display() {  	
 		return "inscriptionsuccess";
 	}
}
