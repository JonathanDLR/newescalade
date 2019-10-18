package org.escalade.webapp.servlets;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.escalade.model.beans.Lieu;
import org.escalade.model.beans.Topo;
import org.escalade.webapp.resources.AbstractResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Servlet implementation class InscriptionServlet
 */
@Controller
@RequestMapping("/account")
public class AccountServlet extends AbstractResource {

       
    @RequestMapping(method = RequestMethod.GET)
 	public String display(HttpSession session, Model model) {
    	if (session.getAttribute("user") != null) {
    		List<Lieu> lieus = getManagerFactory().getLieuManager().getAllLieus();
    		Topo topo = new Topo();
    		
    		model.addAttribute("topoForm", topo);
    		model.addAttribute("lieus", lieus);
    		
    		return "account";
    	} else {
    		return "accounterror";
    	}
 	}
}
