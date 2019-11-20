package org.escalade.business.impl.manager;

import java.util.List;

import org.escalade.business.contract.manager.LieuManager;
import org.escalade.model.beans.Lieu;
import org.escalade.model.exception.NotFoundException;

public class LieuManagerImpl extends AbstractManager implements LieuManager {
	@Override
	public Lieu getLieuById(int pId) throws NotFoundException {
		if (pId < 1L) {
			throw new NotFoundException("Lieu non trouvé : numero = " + pId);
		} else {
			return getDaoFactory().getLieuDao().getLieuById(pId);
		}	
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
