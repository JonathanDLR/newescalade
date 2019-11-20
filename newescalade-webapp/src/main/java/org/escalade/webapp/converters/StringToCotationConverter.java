package org.escalade.webapp.converters;

import org.escalade.model.beans.Cotation;
import org.escalade.model.exception.NotFoundException;
import org.escalade.webapp.resources.AbstractResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.transaction.annotation.Transactional;

public class StringToCotationConverter extends AbstractResource implements Converter<String, Cotation> {
	@Transactional
	public Cotation convert(String pId) {
		Cotation cotation = new Cotation();
		
		try {
			cotation = getManagerFactory().getCotationManager().getCotationById(Integer.parseInt(pId));
		} catch (NumberFormatException | NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cotation;
	}
}
