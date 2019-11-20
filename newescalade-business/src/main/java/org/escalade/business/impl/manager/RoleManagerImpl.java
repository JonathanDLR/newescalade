package org.escalade.business.impl.manager;

import org.escalade.business.contract.manager.RoleManager;
import org.escalade.model.beans.Role;
import org.escalade.model.exception.NotFoundException;

public class RoleManagerImpl extends AbstractManager implements RoleManager {

	@Override
	public Role getRoleById(int pId) throws NotFoundException {
		if (pId < 1L) {
			throw new NotFoundException("Role non trouvé : numero = " + pId);
		} else {
			return getDaoFactory().getRoleDao().getRoleById(pId);
		}
	}

}
