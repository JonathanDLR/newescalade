package org.escalade.business.contract.manager;

import org.escalade.model.beans.Role;
import org.escalade.model.exception.NotFoundException;

public interface RoleManager {
	Role getRoleById(int pId) throws NotFoundException;
}
