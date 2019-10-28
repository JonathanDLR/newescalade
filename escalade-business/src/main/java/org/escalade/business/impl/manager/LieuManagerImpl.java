package org.escalade.business.impl.manager;

import java.util.List;

import org.escalade.business.contract.manager.LieuManager;
import org.escalade.model.beans.Lieu;

public class LieuManagerImpl extends AbstractManager implements LieuManager {
	@Override
	public Lieu getLieuById(int pId) {
		Lieu lieu = getDaoFactory().getLieuDao().getLieuById(pId);
		
		return lieu;
	}
	
	@Override
	public Lieu getLieuByName(String pName) {
		Lieu lieu = getDaoFactory().getLieuDao().getLieuByName(pName);
		
		return lieu;
	}


	@Override
	public List<Lieu> getAllLieus() {
		List<Lieu> lieus = getDaoFactory().getLieuDao().getAllLieu();
		
		return lieus;
	}

	@Override
	public void createLieu(Lieu pLieu, String pName) {
		pLieu.setName(pName);
		getDaoFactory().getLieuDao().createLieu(pLieu);
	}
}
