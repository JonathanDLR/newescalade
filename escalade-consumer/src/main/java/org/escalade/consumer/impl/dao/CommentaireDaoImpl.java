package org.escalade.consumer.impl.dao;

import org.escalade.consumer.contract.dao.CommentaireDao;
import org.escalade.model.beans.Commentaire;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CommentaireDaoImpl extends AbstractDaoImpl implements CommentaireDao {
	@Override
	public void createCom(Commentaire pCom) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(pCom);
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
