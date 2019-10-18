package org.escalade.consumer.impl.dao;

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
}
