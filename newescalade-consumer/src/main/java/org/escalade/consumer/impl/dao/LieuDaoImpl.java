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
	public Lieu getLieuById(int pId) {
		Session session = null;
		Transaction tx = null;
		Lieu lieu = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			lieu = session.get(Lieu.class, pId);
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
		
		return lieu;
	}
	
	@Override
	public Lieu getLieuByName(String pName) {
		Session session = null;
		Transaction tx = null;
		Lieu lieu = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			lieu = (Lieu) session.createQuery("from Lieu as lieu where lieu.name = :name")
								 .setParameter("name", pName)
								 .uniqueResult();
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
		
		return lieu;
	}

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
	
	@Override
	public int createLieu(Lieu pLieu) {
		Session session = null;
		Transaction tx = null;
		int newId = 0;
		
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(pLieu);
			newId = pLieu.getId();
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
