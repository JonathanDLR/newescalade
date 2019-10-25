package org.escalade.consumer.impl.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.escalade.consumer.contract.dao.ReservationDao;
import org.escalade.model.beans.Reservation;
import org.escalade.model.beans.User;
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
	
	@Override
	public void setProcessed(Reservation pResa) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			pResa.setProcessed(true);
		
			session.update(pResa);
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
	
	@Override
	public Reservation getResaById(int pId) {
		Session session = null;
		Transaction tx = null;
		Reservation resa = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			resa = session.get(Reservation.class, pId);
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
		
		return resa;
	}
	
	@Override
	public List<Reservation> getReservationByUser(User pUser) {
		Session session = null;
		Transaction tx = null;
		List<Reservation> resas = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			TypedQuery<Reservation> query = session.createQuery("from Reservation as resa where resa.topo.user"
					+ " = :user and resa.processed = false", Reservation.class);
			resas = query.setParameter("user", pUser).getResultList();
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
		
		return resas;
	}
}
