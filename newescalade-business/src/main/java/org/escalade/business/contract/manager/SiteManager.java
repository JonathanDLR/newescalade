package org.escalade.business.contract.manager;

import java.util.List;

import org.escalade.model.beans.Cotation;
import org.escalade.model.beans.Lieu;
import org.escalade.model.beans.Site;

public interface SiteManager {
	Site getSiteByNom(String pNom);
	List<Site> getAllSite(Lieu pLieu, Cotation pCot, int pSecteur);
	void createSite(Site pSite, String pNom);
	void toggleOfficial(Site pSite);
}
