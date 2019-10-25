package org.escalade.consumer.impl.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.escalade.consumer.contract.dao.SiteDao;
import org.escalade.model.beans.Cotation;
import org.escalade.model.beans.Lieu;
import org.escalade.model.beans.Site;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {
	@Override
	public Site getSiteByNom(String pNom) {
		Session session = null;
		Transaction tx = null;
		Site site = null;
		
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			site = (Site) session.createQuery("SELECT s FROM Site s WHERE s.nom = :nom")
								 .setParameter("nom", pNom)
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
		
		return site;
	}
	
	@Override
	public List<Site> getAllSite(Lieu pLieu, Cotation pCot, int pSecteur) {
		Session session = null;
		Transaction tx = null;
		List<Site> sites = new ArrayList<Site>();
		
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			String hql = "SELECT s FROM Site s where 1=1";
			if (pLieu != null) {
				hql = hql.concat(" AND s.lieu = :lieu");
			}
			if (pCot != null) {
				hql = hql.concat(" AND s.cotation = :cotation");
			}
			if (pSecteur != 0) {
				hql = hql.concat(" AND s.nbreSecteur = :secteur");
			}
			TypedQuery<Site> query =  session.createQuery(hql, Site.class);
			if (pLieu != null) {
				query.setParameter("lieu", pLieu);
			}
			if (pCot != null) {
				query.setParameter("cotation", pCot);
			}
			if (pSecteur != 0) {
				query.setParameter("secteur", pSecteur);
			}
			sites = query.getResultList();
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
		
		return sites;
	}
	
	@Override
	public void createSite(Site pSite) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(pSite);
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
