package org.escalade.business.impl.manager;

import java.util.List;

import org.escalade.business.contract.manager.LieuManager;
import org.escalade.model.beans.Lieu;

public class LieuManagerImpl extends AbstractManager implements LieuManager {

	@Override
	public List<Lieu> getAllLieus() {
		List<Lieu> lieus = getDaoFactory().getLieuDao().getAllLieu();
		
		return lieus;
	}

}
