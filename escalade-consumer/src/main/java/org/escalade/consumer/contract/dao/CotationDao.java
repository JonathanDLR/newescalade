package org.escalade.consumer.contract.dao;

import java.util.List;

import org.escalade.model.beans.Cotation;

public interface CotationDao {
	Cotation getCotationById(int pId);
	List<Cotation> getAllCot();
}
