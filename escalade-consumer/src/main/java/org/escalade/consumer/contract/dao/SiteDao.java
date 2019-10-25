package org.escalade.consumer.contract.dao;

import java.util.List;

import org.escalade.model.beans.Site;

public interface SiteDao {
	Site getSiteByNom(String pNom);
	List<Site> getAllSite();
	void createSite(Site pSite);
}
