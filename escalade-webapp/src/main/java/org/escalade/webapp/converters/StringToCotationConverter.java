package org.escalade.webapp.converters;

import org.escalade.model.beans.Cotation;
import org.escalade.webapp.resources.AbstractResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.transaction.annotation.Transactional;

public class StringToCotationConverter extends AbstractResource implements Converter<String, Cotation> {
	@Transactional
	public Cotation convert(String pId) {
		return getManagerFactory().getCotationManager().getCotationById(Integer.parseInt(pId));
	}
}
