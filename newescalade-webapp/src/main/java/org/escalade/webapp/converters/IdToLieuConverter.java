package org.escalade.webapp.converters;

import org.escalade.model.beans.Lieu;
import org.escalade.model.exception.NotFoundException;
import org.escalade.webapp.resources.AbstractResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.transaction.annotation.Transactional;

public class IdToLieuConverter extends AbstractResource implements Converter<String, Lieu> {
	@Transactional
	public Lieu convert(String pId) {
		Lieu lieu = new Lieu();
		try {
			lieu = getManagerFactory().getLieuManager().getLieuById(Integer.parseInt(pId));
		} catch (NumberFormatException | NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lieu;
	}
}
