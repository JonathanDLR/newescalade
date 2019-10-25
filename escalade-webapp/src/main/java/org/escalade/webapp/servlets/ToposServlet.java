package org.escalade.webapp.servlets;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.escalade.model.beans.Reservation;
import org.escalade.model.beans.Topo;
import org.escalade.model.beans.User;
import org.escalade.webapp.resources.AbstractResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Servlet implementation class AccueilSubtitle
 */
@Controller
@RequestMapping("/topos")
public class ToposServlet extends AbstractResource {
	/**
	 * Sending the view of available topo
	 * @param session saving the topo list in session
	 * @return the view
	 */
    @RequestMapping(method = RequestMethod.GET)
	public String display(HttpSession session) {
    	if (session.getAttribute("user") != null) {
    		
    		// SEND TOPOS DISPO TO JSP
    		List<Topo> topos = getManagerFactory().getTopoManager().getTopoDisp((User) session.getAttribute("user"));
    		session.setAttribute("topos", topos);
    		
    		return "topos";
    	} else {
    		return "accounterror";
    	}
	}
    
    /**
     * Creating a resa
     * @param newResa the topo name sending by AJAX
     * @param session get the user in session who made the resa
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public String createResaFromAjax(@RequestParam("newResa") String newResa, HttpSession session) {
    	//GET TOPO AND CREATE RESA
    	Topo topo = getManagerFactory().getTopoManager().getTopoByName(newResa);
    	Reservation resa = new Reservation();
    	
    	
    	getManagerFactory().getReservationManager().createResa(resa, topo, (User) session.getAttribute("user"));
    	
    	return "Votre demande de réservation a bien été effectuée.";
    }
}
