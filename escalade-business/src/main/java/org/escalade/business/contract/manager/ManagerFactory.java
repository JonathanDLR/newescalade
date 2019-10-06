package org.escalade.business.contract.manager;


public interface ManagerFactory {
	CommentaireManager getCommentaireManager();
	void setCommentaireManager(CommentaireManager pCommentaireManager);

	ReservationManager getReservationManager();	
	void setReservationManager(ReservationManager pReservationManager);
	
	SiteManager getSiteManager();
	void setSiteManager(SiteManager pSiteManager);
	
	TopoManager getTopoManager();
	void setTopoManager(TopoManager pTopoManager);
	
	UserManager getUserManager();
	void setUserManager(UserManager pUserManager);
}
