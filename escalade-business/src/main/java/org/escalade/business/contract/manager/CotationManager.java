package org.escalade.business.contract.manager;

import java.util.List;

import org.escalade.model.beans.Cotation;

public interface CotationManager {
	Cotation getCotationById(int pId);
	Cotation getCotationByCot(String pCot);
	List<Cotation> getAllCotation();
}
