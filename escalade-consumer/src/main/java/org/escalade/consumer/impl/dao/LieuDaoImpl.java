package org.escalade.consumer.impl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.escalade.consumer.contract.dao.LieuDao;
import org.escalade.model.beans.Lieu;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LieuDaoImpl extends AbstractDaoImpl implements LieuDao {

	@Override
	public List<Lieu> getAllLieu() {
		Session session = null;
		Transaction tx = null;
		List<Lieu> lieus = new ArrayList<Lieu>();
		
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			TypedQuery<Lieu> query =  session.createQuery("SELECT l FROM Lieu l", Lieu.class);
			lieus = query.getResultList();
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
		
		return lieus;
	}
}
