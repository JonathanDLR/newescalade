package org.escalade.business.contract.manager;

import org.escalade.model.beans.User;

public interface UserManager {
	void createUser(User pUser);
	User getUserByLogin(String pLogin);
}
