package org.escalade.webapp.servlets;



import javax.validation.Valid;

import org.apache.commons.validator.routines.EmailValidator;
import org.escalade.model.beans.User;
import org.escalade.webapp.resources.AbstractResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Servlet implementation class InscriptionServlet
 */
@Controller
@RequestMapping("/inscription")
public class InscriptionServlet extends AbstractResource {
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
       
    @RequestMapping(method = RequestMethod.GET)
 	public String display(Model model) {
    	User user = new User();
    	
    	model.addAttribute("userForm", user);
    	
 		return "inscription";
 	}
    
    @RequestMapping(method = RequestMethod.POST)
    public String createEmployerFromForm(@Valid @ModelAttribute("userForm") User pUser, BindingResult br) {  
    	User user = getManagerFactory().getUserManager().getUserByLogin(pUser.getLogin());
    	System.out.print(pUser.getPswd());
    	
    	if (br.hasErrors()) {
    		return "inscription";
    	} else if  (!EmailValidator.getInstance().isValid(pUser.getLogin())){
    		br.rejectValue("login", "error.mailNotValid", "Veuillez renseigner un mail valide.");
    		return "inscription";	
    	} else if (user != null) {
    		br.rejectValue("login", "error.userNotUnique", "Ce mail est déjà enregistré.");
    		return "inscription";
    	} else if (!pUser.getPswd().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,}$")) {
    		br.rejectValue("pswd", "error.pswdNotValid", "Votre mot de passe doit contenir au minimum une lettre minuscule, une lettre majuscule, un chiffre et 6 caractères.");
    		return "inscription";
    	} else {
    		pUser.setPswd(encoder.encode(pUser.getPswd()));
    		pUser.setRole(getManagerFactory().getRoleManager().getRoleById(1));
        	getManagerFactory().getUserManager().createUser(pUser);
        	
        	return "redirect:/inscriptionsuccess";
    	}
    }
}
