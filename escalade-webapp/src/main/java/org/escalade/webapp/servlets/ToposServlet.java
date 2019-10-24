package org.escalade.webapp.servlets;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.escalade.model.beans.Reservation;
import org.escalade.model.beans.Topo;
import org.escalade.model.beans.User;
import org.escalade.webapp.resources.AbstractResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping(method = RequestMethod.GET)
	public String display(HttpSession session, Model model) {
    	if (session.getAttribute("user") != null) {
    		
    		// SEND TOPOS DISPO TO JSP
    		List<Topo> topos = getManagerFactory().getTopoManager().getTopoDisp((User) session.getAttribute("user"));
    		session.setAttribute("topos", topos);
    		
    		return "topos";
    	} else {
    		return "accounterror";
    	}
	}
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public String createResaFromAjax(@RequestParam("newResa") String newResa, HttpSession session) {
    	//GET TOPO AND CREATE RESA
    	Topo topo = getManagerFactory().getTopoManager().getTopoByName(newResa);
    	Reservation resa = new Reservation();
    	resa.setTopo(topo);
    	resa.setUserDemandeur((User) session.getAttribute("user"));
    	
    	getManagerFactory().getReservationManager().createResa(resa);
    	
    	return "Votre demande de réservation a bien été effectuée.";
    }
}
