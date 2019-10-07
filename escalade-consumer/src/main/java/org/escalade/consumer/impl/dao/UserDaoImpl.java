package org.escalade.consumer.impl.dao;

import org.escalade.consumer.contract.dao.UserDao;
import org.escalade.model.beans.User;

public class UserDaoImpl extends AbstractDaoImpl implements UserDao {
	@Override
	public void createUser(User pUser) {
		getCurrentSession().beginTransaction();
		getCurrentSession().save(pUser);
		getCurrentSession().getTransaction().commit();
	}

}
