package org.escalade.consumer.impl.dao;

import org.escalade.consumer.contract.dao.RoleDao;
import org.escalade.model.beans.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoleDaoImpl extends AbstractDaoImpl implements RoleDao {

	@Override
	public Role getRoleById(int pId) {
		Session session = null;
		Transaction tx = null;
		Role role = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			role = session.byId(Role.class).getReference(pId);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}	
		
		return role;
	}
	
	@Override
	public int createRole(Role pRole) {
		Session session = null;
		Transaction tx = null;
		int newId = 0;
		
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(pRole);
			newId = pRole.getId();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}		
		} finally {
			if (session != null) {
				session.close();
			}			
		}
		
		return newId;
	}
}
