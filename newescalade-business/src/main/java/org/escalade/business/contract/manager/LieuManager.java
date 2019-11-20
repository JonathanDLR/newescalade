package org.escalade.business.contract.manager;

import java.util.List;

import org.escalade.model.beans.Lieu;
import org.escalade.model.exception.NotFoundException;

public interface LieuManager {
	Lieu getLieuById(int pId) throws NotFoundException;
	Lieu getLieuByName(String pName);
	List<Lieu> getAllLieus();
	void createLieu(Lieu pLieu, String pName);
}
