package org.escalade.business.contract.manager;

import java.util.List;

import org.escalade.model.beans.Site;

public interface SiteManager {
	Site getSiteByNom(String pNom);
	List<Site> getAllSite();
	void createSite(Site pSite, String pNom);
}
