package org.escalade.consumer.contract.dao;

public interface DaoFactory {
	CommentaireDao getCommentaireDao();
	void setCommentaireDao(CommentaireDao pCommentaireDao);
	
	CotationDao geCotationDao();
	void setCotationDao(CotationDao pCotationDao);
	
	LieuDao getLieuDao();
	void setLieuDao(LieuDao pLieuDao);
	
	ReservationDao getReservationDao();
	void setReservationDao(ReservationDao pReservationDao);
	
	RoleDao getRoleDao();
	void setRoleDao(RoleDao pRoleDao);

	SiteDao getSiteDao();
	void setSiteDao(SiteDao pSiteDao);
	
	TopoDao getTopoDao();
	void setTopoDao(TopoDao pTopoDao);
	
	UserDao getUserDao();
	void setUserDao(UserDao pUserDao);
}
