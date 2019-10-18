package org.escalade.webapp.servlets;



import javax.servlet.http.HttpSession;
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
@RequestMapping("/connexion")
public class ConnexionServlet extends AbstractResource {
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @RequestMapping(method = RequestMethod.GET)
 	public String display(Model model) {
    	User user = new User();
    	
    	model.addAttribute("userForm", user);
    	
 		return "connexion";
 	}
    
    @RequestMapping(method = RequestMethod.POST)
    public String createEmployerFromForm(@Valid @ModelAttribute("userForm") User pUser, BindingResult br, 
    		HttpSession session, Model model) {
    	User user = getManagerFactory().getUserManager().getUserByLogin(pUser.getLogin());
    	String error = "Identifiant ou mot de passe incorect";
    	
    	// CHECK INFO BEFORE CREATING SESSION
    	if (pUser.getLogin() == null) {
    		br.rejectValue("login", "error.mailEmpty", "Veuillez renseigner votre mail.");
    		return "connexion";
    	} else if (!EmailValidator.getInstance().isValid(pUser.getLogin())) {
    		br.rejectValue("login", "error.mailNotValid", "Veuillez renseigner un mail valide.");
    		return "connexion";
    	} else if (pUser.getPswd() == null) {
    		br.rejectValue("pswd", "error.pswdEmpty", "Veuillez renseigner votre mot de passe.");
    		return "connexion";
    	} else if (!pUser.getPswd().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,}$")) {
    		br.rejectValue("pswd", "error.pswdNotValid", "Votre mot de passe doit contenir au minimum une lettre minuscule, une lettre majuscule, un chiffre et 6 caractères.");
    		return "connexion";
    	} else if (user == null) {
    		model.addAttribute("error", error);
    		return "connexion";
    	} else if (!encoder.matches(pUser.getPswd(), user.getPswd())) {
    		model.addAttribute("error", error);
    		return "connexion";
    	} else {
        	session.setAttribute("user", user);
        	return "redirect:/";
    	}	
    }
}
