package org.escalade.consumer.impl.dao;

import org.escalade.consumer.contract.dao.CommentaireDao;
import org.escalade.model.beans.Commentaire;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CommentaireDaoImpl extends AbstractDaoImpl implements CommentaireDao {
	@Override
	public int createCom(Commentaire pCom) {
		Session session = null;
		Transaction tx = null;
		int newId = 0;
		
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(pCom);
			newId = pCom.getId();
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
	
	@Override
	public void updateCom(Commentaire pCommentaire) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();	
			session.update(pCommentaire);
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
	public void deleteCom(int pId) {
		Session session = null;
		Transaction tx = null;
		Commentaire commentaire = null;
		
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			commentaire = session.get(Commentaire.class, pId);
			session.delete(commentaire);
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
	public Commentaire getCommentaireById(int pId) {
		Session session = null;
		Transaction tx = null;
		Commentaire commentaire = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			commentaire = session.get(Commentaire.class, pId);
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
		
		return commentaire;
	}
}
