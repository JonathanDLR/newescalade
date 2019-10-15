package org.escalade.business.impl.manager;

import org.escalade.business.contract.manager.UserManager;
import org.escalade.model.beans.User;

public class UserManagerImpl extends AbstractManager implements UserManager {
	@Override
	public void createUser(User pUser) {
		getDaoFactory().getUserDao().createUser(pUser);
	}
	
	@Override
	public User getUserByLogin(String pLogin) {
		User user = getDaoFactory().getUserDao().getUserByLogin(pLogin);
		
		return user;
	}
}
