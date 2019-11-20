package org.escalade.business.contract.manager;

import java.util.List;

import org.escalade.model.beans.Cotation;
import org.escalade.model.exception.NotFoundException;

public interface CotationManager {
	Cotation getCotationById(int pId) throws NotFoundException;
	Cotation getCotationByCot(String pCot);
	List<Cotation> getAllCotation();
}
