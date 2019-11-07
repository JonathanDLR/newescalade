package org.escalade.consumer.impl.dao;

import org.escalade.consumer.contract.dao.CommentaireDao;
import org.escalade.consumer.contract.dao.CotationDao;
import org.escalade.consumer.contract.dao.DaoFactory;
import org.escalade.consumer.contract.dao.LieuDao;
import org.escalade.consumer.contract.dao.ReservationDao;
import org.escalade.consumer.contract.dao.RoleDao;
import org.escalade.consumer.contract.dao.SiteDao;
import org.escalade.consumer.contract.dao.TopoDao;
import org.escalade.consumer.contract.dao.UserDao;

public class DaoFactoryImpl implements DaoFactory {
	private CommentaireDao commentaireDao;
	private CotationDao cotationDao;
	private LieuDao lieuDao;
	private ReservationDao reservationDao;
	private RoleDao roleDao;
	private SiteDao siteDao;
	private TopoDao topoDao;
	private UserDao userDao;
	
	public CommentaireDao getCommentaireDao() {
		return this.commentaireDao;
	}

	public void setCommentaireDao(CommentaireDao pCommentaireDao) {
		this.commentaireDao = pCommentaireDao;
	}

	public CotationDao getCotationDao() {
		return this.cotationDao;
	}

	public void setCotationDao(CotationDao pCotationDao) {
		this.cotationDao = pCotationDao;
	}

	public LieuDao getLieuDao() {
		return this.lieuDao;
	}

	public void setLieuDao(LieuDao pLieuDao) {
		this.lieuDao = pLieuDao;
	}

	public ReservationDao getReservationDao() {
		return this.reservationDao;
	}

	public void setReservationDao(ReservationDao pReservationDao) {
		this.reservationDao = pReservationDao;
	}
	
	public RoleDao getRoleDao() {
		return this.roleDao;
	}
	
	public void setRoleDao(RoleDao pRoleDao) {
		this.roleDao = pRoleDao;
	}

	public SiteDao getSiteDao() {
		return this.siteDao;
	}

	public void setSiteDao(SiteDao pSiteDao) {
		this.siteDao = pSiteDao;
	}

	public TopoDao getTopoDao() {
		return this.topoDao;
	}

	public void setTopoDao(TopoDao pTopoDao) {
		this.topoDao = pTopoDao;
	}

	public UserDao getUserDao() {
		return this.userDao;
	}

	public void setUserDao(UserDao pUserDao) {
		this.userDao = pUserDao;
	}

}
