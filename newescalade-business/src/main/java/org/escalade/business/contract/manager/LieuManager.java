package org.escalade.business.contract.manager;

import java.util.List;

import org.escalade.model.beans.Lieu;

public interface LieuManager {
	Lieu getLieuById(int pId);
	Lieu getLieuByName(String pName);
	List<Lieu> getAllLieus();
	void createLieu(Lieu pLieu, String pName);
}
