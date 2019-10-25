package org.escalade.business.impl.manager;

import java.util.List;

import org.escalade.business.contract.manager.CotationManager;
import org.escalade.model.beans.Cotation;

public class CotationManagerImpl extends AbstractManager implements CotationManager {
	@Override
	public Cotation getCotationById(int pId) {
		return getDaoFactory().getCotationDao().getCotationById(pId);
	}
	
	@Override
	public List<Cotation> getAllCotation() {
		return getDaoFactory().getCotationDao().getAllCot();
	}

}
