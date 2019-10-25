package org.escalade.business.impl.manager;

import org.escalade.business.contract.manager.UserManager;
import org.escalade.model.beans.Role;
import org.escalade.model.beans.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserManagerImpl extends AbstractManager implements UserManager {
	@Override
	public void createUser(User pUser, String pPseudo, Role pRole) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		pUser.setPseudo(pPseudo);
		pUser.setLogin(pUser.getLogin());
		pUser.setPswd(encoder.encode(pUser.getPswd()));
		pUser.setRole(pRole);
		getDaoFactory().getUserDao().createUser(pUser);
	}
	
	@Override
	public User getUserByLogin(String pLogin) {
		User user = getDaoFactory().getUserDao().getUserByLogin(pLogin);
		
		return user;
	}
}
