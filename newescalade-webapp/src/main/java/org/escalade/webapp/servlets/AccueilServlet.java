package org.escalade.webapp.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Servlet implementation class AccueilSubtitle
 */
@Controller
@RequestMapping("/")
public class AccueilServlet {
	/**
	 * Sending the home view
	 * @return the view
	 */
    @RequestMapping(method = RequestMethod.GET)
	public String display() {

		return "accueil";
	}
}
