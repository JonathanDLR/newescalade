package org.escalade.business.impl.manager;

import java.util.List;

import org.escalade.business.contract.manager.SiteManager;
import org.escalade.model.beans.Site;

public class SiteManagerImpl extends AbstractManager implements SiteManager {

	@Override
	public Site getSiteByNom(String pNom) {
		return getDaoFactory().getSiteDao().getSiteByNom(pNom);
	}
	
	@Override
	public List<Site> getAllSite() {
		return getDaoFactory().getSiteDao().getAllSite();
	}

	@Override
	public void createSite(Site pSite, String pNom) {
		pSite.setNom(pNom);
		getDaoFactory().getSiteDao().createSite(pSite);
	}

}
