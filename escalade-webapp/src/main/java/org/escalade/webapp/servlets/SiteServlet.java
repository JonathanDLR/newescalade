package org.escalade.webapp.servlets;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.escalade.model.beans.Cotation;
import org.escalade.model.beans.Lieu;
import org.escalade.model.beans.Site;
import org.escalade.webapp.resources.AbstractResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class SiteServlet
 */
@Controller
public class SiteServlet extends AbstractResource {
	Lieu pLieu = null;
	Cotation pCot = null;
	int pSecteur = 0;

	@RequestMapping(value = "/site", method = RequestMethod.GET)
	public String display(HttpSession session) {
		
		
    	// GET THE SITE
   		List<Site> sites = getManagerFactory().getSiteManager().getAllSite(pLieu, pCot, pSecteur);
   		session.setAttribute("sites", sites);
   		
   		// GET INFO FOR THE SEARCHING
   		List<Lieu> lieus = getManagerFactory().getLieuManager().getAllLieus();
   		session.setAttribute("lieus", lieus);
   		List<Cotation> cotations = getManagerFactory().getCotationManager().getAllCotation();
   		session.setAttribute("cotations", cotations);
    		   		
   		return "sites";
	}

	@ResponseBody
	@RequestMapping(value ="/search", method = RequestMethod.POST)
	public String search(@RequestParam("lieu") String lieu, @RequestParam("cotation") String cotation,
				@RequestParam("secteur") String secteur, HttpSession session) {
		pLieu = getManagerFactory().getLieuManager().getLieuByName(lieu);
		pCot = getManagerFactory().getCotationManager().getCotationByCot(cotation);
		if (secteur != "") {
			pSecteur = Integer.parseInt(secteur);
		} else {
			pSecteur = 0;
		}
		
		
		// Sending all the sites to jsp with JSON
    	List<Site> sites = getManagerFactory().getSiteManager().getAllSite(pLieu, pCot, pSecteur);
    	session.setAttribute("sites", sites);
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	
    	return gson.toJson(sites);
	}
}
