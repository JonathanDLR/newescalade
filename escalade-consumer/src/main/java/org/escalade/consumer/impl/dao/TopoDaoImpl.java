package org.escalade.consumer.impl.dao;

import javax.persistence.TypedQuery;

import org.escalade.consumer.contract.dao.TopoDao;
import org.escalade.model.beans.Topo;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {
	@Override
	public void createTopo(Topo pTopo) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(pTopo);
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
	public Topo getTopoByName(String pName) {
		Session session = null;
		Transaction tx = null;
		Topo topo = null;
		
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			TypedQuery<Topo> query =  session.createQuery("SELECT t FROM Topo t WHERE t.name = :name", Topo.class);
			query.setParameter("name", pName);
			topo = query.getSingleResult();
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
		
		return topo;
	}
}
