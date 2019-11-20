package org.escalade.webapp.servlets;



import javax.validation.Valid;

import org.apache.commons.validator.routines.EmailValidator;
import org.escalade.model.beans.Role;
import org.escalade.model.beans.User;
import org.escalade.model.exception.NotFoundException;
import org.escalade.webapp.resources.AbstractResource;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
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
       
	/**
	 * Sending the inscription view
	 * @param model pass the inscription form
	 * @return inscription view
	 */
    @RequestMapping(method = RequestMethod.GET)
 	public String display(Model model) {
    	User user = new User();
    	
    	model.addAttribute("userForm", user);
    	
 		return "inscription";
 	}
    
    /**
     * Creating the user
     * @param pUser user created by form
     * @param br
     * @return
     * @throws NotFoundException 
     */
    @RequestMapping(method = RequestMethod.POST)
    public String createUserFromForm(@Valid @ModelAttribute("userForm") User pUser, BindingResult br) throws NotFoundException {  
    	User user = getManagerFactory().getUserManager().getUserByLogin(pUser.getLogin());
    	
    	// CHECK INFO BEFORE INJECTING IN DB
    	if (br.hasErrors()) {
    		return "inscription";
    	} else if (!pUser.getPseudo().matches("^[A-zÀ-ÖØ-öø-ÿ0-9_\\-]+$")) {
    		br.rejectValue("pseudo", "error.pseudoNotValid", "Votre pseudo ne peut contenir que des caractères alphanumériques, des _ et des -");
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
    		
    		//Sanitizing user value and save in db
    		PolicyFactory sanitizer = new HtmlPolicyBuilder().toFactory();
    		
    		String pPseudo = sanitizer.sanitize(pUser.getPseudo());
    	
    		Role pRole = getManagerFactory().getRoleManager().getRoleById(1);
        	getManagerFactory().getUserManager().createUser(pUser, pPseudo, pRole);
        	
        	return "redirect:/inscriptionsuccess";
    	}
    }
}
