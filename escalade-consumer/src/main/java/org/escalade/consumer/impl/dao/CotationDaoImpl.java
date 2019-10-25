package org.escalade.consumer.impl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.escalade.consumer.contract.dao.CotationDao;
import org.escalade.model.beans.Cotation;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CotationDaoImpl extends AbstractDaoImpl implements CotationDao {
	@Override
	public Cotation getCotationById(int pId) {
		Session session = null;
		Transaction tx = null;
		Cotation cotation = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			cotation = session.get(Cotation.class, pId);
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
		
		return cotation;
	}
	
	@Override
	public Cotation getCotationByCot(String pCot) {
		Session session = null;
		Transaction tx = null;
		Cotation cotation = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			cotation = (Cotation) session.createQuery("from Cotation as c where c.cot = :cot")
								 .setParameter("cot", pCot)
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
		
		return cotation;
	}
	
	@Override
	public List<Cotation> getAllCot() {
		Session session = null;
		Transaction tx = null;
		List<Cotation> cotations = new ArrayList<Cotation>();
		
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			TypedQuery<Cotation> query =  session.createQuery("SELECT c FROM Cotation c", Cotation.class);
			cotations = query.getResultList();
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
		
		return cotations;
	}
}
