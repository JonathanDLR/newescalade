package org.escalade.webapp.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Servlet implementation class AccueilSubtitle
 */
@Controller
@RequestMapping("/")
public class AccueilServlet {
       
    public AccueilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @RequestMapping(method = RequestMethod.GET)
	public String display(Model model) {

		return "accueil";
	}
}
