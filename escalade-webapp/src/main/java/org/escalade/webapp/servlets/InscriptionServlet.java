package org.escalade.webapp.servlets;


import javax.servlet.http.HttpServlet;

import org.escalade.model.beans.Role;
import org.escalade.model.beans.User;
import org.escalade.webapp.resources.AbstractResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Servlet implementation class InscriptionServlet
 */
@Controller
@RequestMapping("/inscription")
public class InscriptionServlet extends AbstractResource {
       
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
    	
    	Role role = new Role();
    	role.setId(1);
    	role.setName("registered");
    	User user = new User();
    	user.setRole(role);
    	model.addAttribute("userForm", user);
    	
 		return "inscription";
 	}
    
    @RequestMapping(method = RequestMethod.POST)
    public String createEmployerFromForm(@ModelAttribute("userForm") User pUser) {   
    	getManagerFactory().getUserManager().createUser(pUser);
    	return "redirect:/";
    }
}
