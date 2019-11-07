package org.escalade.business.contract.manager;

import org.escalade.model.beans.Role;
import org.escalade.model.beans.User;

public interface UserManager {
	void createUser(User pUser, String pSeudo, Role pRole);
	User getUserByLogin(String pLogin);
}
