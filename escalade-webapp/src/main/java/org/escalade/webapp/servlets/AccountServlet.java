package org.escalade.webapp.servlets;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.escalade.model.beans.Lieu;
import org.escalade.model.beans.Reservation;
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
	/**
	 * Sending the account view
	 * @param session get the connected user, pass lieus
	 * @param model pass the form to create topo
	 * @return
	 */
    @RequestMapping(value="/account", method = RequestMethod.GET)
 	public String display(HttpSession session, Model model) {
    	if (session.getAttribute("user") != null) {
    		// GET THE LIEU
    		List<Lieu> lieus = getManagerFactory().getLieuManager().getAllLieus();
    		
    		// GET THE RESERVATION
    		List<Reservation> resas = getManagerFactory().getReservationManager()
    													 .getReservationByUser((User) session.getAttribute("user")); 
    		
    		
    		Topo topo = new Topo();
    		
    		model.addAttribute("topoForm", topo);   		
    		session.setAttribute("lieus", lieus);
    		session.setAttribute("resas", resas);
    		
    		return "account";
    	} else {
    		return "accounterror";
    	}
 	}
    
    /**
     * Creating topo
     * @param pTopo the topo created with form value
     * @param br
     * @param model
     * @param session
     * @return
     * @throws ParseException
     */
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
        		// SANITIZE INPUT VALUE
        		PolicyFactory sanitizer = new HtmlPolicyBuilder().toFactory();
        		String pName = sanitizer.sanitize(pTopo.getName());
        		String pDescription = sanitizer.sanitize(pTopo.getDescription());
        		
        		// CREATING TOPO
            	getManagerFactory().getTopoManager().createTopo(pTopo, pName, pDescription,
            			(User) session.getAttribute("user"));
            	
            	// UPDATING USER IN HTTPSESSION
            	User user = (User) session.getAttribute("user");
            	session.setAttribute("user", getManagerFactory().getUserManager().getUserByLogin(user.getLogin()));
            	
            	model.addAttribute("rep", "Votre topo a bien été créé.");
            	return "account";
        	}
    	} else {
    		return "accounterror";
    	}
    	
    }
    
    /**
     * Crating a new lieu
     * @param newlieu name of the lieu sending by AJAX
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/newlieu", method = RequestMethod.POST)
    public String newlieu(@RequestParam("newlieu") String newlieu) {
    	Lieu lieu = getManagerFactory().getLieuManager().getLieuByName(newlieu);
    	if (newlieu == "") {
    		return "Veuillez renseigner votre lieu.";
    	} else if (lieu != null) {
    		return "Un lieu avec ce nom existe déjà.";
    	} else {
    		PolicyFactory sanitizer = new HtmlPolicyBuilder().toFactory();
        	
        	// Creating the new lieu
        	Lieu newLieu = new Lieu();
        	newLieu.setName(sanitizer.sanitize(newlieu));
        	// Creating the new lieu
        	getManagerFactory().getLieuManager().createLieu(newLieu);
        	
        	// Sending all the lieu to jsp with JSON
        	List<Lieu> lieus = getManagerFactory().getLieuManager().getAllLieus();
        	Gson gson = new GsonBuilder().setPrettyPrinting().create();
        	
        	return gson.toJson(lieus);
    	} 	
    }
    
    /**
     * Accept the reservation, set topo unavalaible
     * @param procResa id of the reservation
     * @param procTopo name of the topo
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/procresa", method = RequestMethod.POST)
    public String procResa(@RequestParam("procResa") int procResa, @RequestParam("procTopo") String procTopo,
    		HttpSession session) {
    	//PROC THE RESA
    	Reservation resa = getManagerFactory().getReservationManager().getReservationById(procResa);
    	getManagerFactory().getReservationManager().setProcessed(resa);
    	
    	// SET TOPO NOT DISPO
    	Topo topo = getManagerFactory().getTopoManager().getTopoByName(procTopo);
    	getManagerFactory().getTopoManager().topoToggleDisp(topo);
    	
    	// UPDATING USER IN HTTPSESSION
    	User user = (User) session.getAttribute("user");
    	session.setAttribute("user", getManagerFactory().getUserManager().getUserByLogin(user.getLogin()));
    	
    	return "Vous avez accepter la demande de réservation de ".concat(resa.getUserDemandeur().getPseudo());
    }
    
    /**
     * Toggle disponibility of the topo
     * @param topoName
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/toggletopo", method = RequestMethod.POST)
    public String toggleTopo(@RequestParam("topoName") String topoName, HttpSession session) {
    	Topo topo = getManagerFactory().getTopoManager().getTopoByName(topoName);
    	getManagerFactory().getTopoManager().topoToggleDisp(topo);
    	
    	// UPDATING USER IN HTTPSESSION
    	User user = (User) session.getAttribute("user");
    	session.setAttribute("user", getManagerFactory().getUserManager().getUserByLogin(user.getLogin()));
    	
    	return "La disponibilité du topo a bien été modifiée";
    }
}
