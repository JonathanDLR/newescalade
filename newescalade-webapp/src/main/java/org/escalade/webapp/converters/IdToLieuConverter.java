package org.escalade.webapp.converters;

import org.escalade.model.beans.Lieu;
import org.escalade.webapp.resources.AbstractResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.transaction.annotation.Transactional;

public class IdToLieuConverter extends AbstractResource implements Converter<String, Lieu> {
	@Transactional
	public Lieu convert(String pId) {
		return getManagerFactory().getLieuManager().getLieuById(Integer.parseInt(pId));
	}
}
