package org.escalade.webapp.servlets;


import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Servlet implementation class InscriptionServlet
 */
@Controller
@RequestMapping("/inscription")
public class InscriptionServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @RequestMapping(method = RequestMethod.GET)
 	public String display(Model model) {
    	model.addAttribute("title", "Amis Escalade: Inscription");
 		return "inscription";
 	}

}
