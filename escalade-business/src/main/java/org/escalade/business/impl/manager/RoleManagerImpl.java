package org.escalade.business.impl.manager;

import org.escalade.business.contract.manager.RoleManager;
import org.escalade.model.beans.Role;

public class RoleManagerImpl extends AbstractManager implements RoleManager {

	@Override
	public Role getRoleById(int pId) {
		Role role = getDaoFactory().getRoleDao().getRoleById(pId);
		
		return role;
	}

}
