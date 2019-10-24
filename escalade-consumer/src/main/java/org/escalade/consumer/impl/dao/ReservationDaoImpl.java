package org.escalade.consumer.impl.dao;

import org.escalade.consumer.contract.dao.ReservationDao;
import org.escalade.model.beans.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationDaoImpl extends AbstractDaoImpl implements ReservationDao {
	@Override
	public void createResa(Reservation pResa) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(pResa);
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
	}
}
