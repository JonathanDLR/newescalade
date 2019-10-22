package org.escalade.webapp.servlets;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.text.StringEscapeUtils;
import org.escalade.model.beans.Lieu;
import org.escalade.model.beans.Topo;
import org.escalade.model.beans.User;
import org.escalade.webapp.resources.AbstractResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


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
    		session.setAttribute("lieus", lieus);
    		
    		return "account";
    	} else {
    		return "accounterror";
    	}
 	}
    
    @RequestMapping(method = RequestMethod.POST)
    public String createTopoFromForm(@Valid @ModelAttribute("topoForm") Topo pTopo, BindingResult br, Model model,
    		HttpSession session) throws ParseException {  
    	Topo topo = getManagerFactory().getTopoManager().getTopoByName(pTopo.getName());
    	
    	
    	// CHECK INFO BEFORE INJECTING IN DB
    	if (br.hasErrors()) {    		
    		return "account";
    	} else if (topo != null) {
    		br.rejectValue("name", "error.topoNotUnique", "Un topo avec ce nom existe déjà.");
    		
    		return "account";
    	} 
   
    	else {
    		pTopo.setName(StringEscapeUtils.escapeHtml4(pTopo.getName()));
    		pTopo.setDescription(StringEscapeUtils.escapeHtml4(pTopo.getDescription()));
    		pTopo.setUser((User) session.getAttribute("user"));
        	getManagerFactory().getTopoManager().createTopo(pTopo);
        	
        	return "account";
    	}
    }
}
