package org.escalade.business.impl.manager;

import org.escalade.business.contract.manager.CommentaireManager;
import org.escalade.business.contract.manager.CotationManager;
import org.escalade.business.contract.manager.LieuManager;
import org.escalade.business.contract.manager.ManagerFactory;
import org.escalade.business.contract.manager.ReservationManager;
import org.escalade.business.contract.manager.RoleManager;
import org.escalade.business.contract.manager.SiteManager;
import org.escalade.business.contract.manager.TopoManager;
import org.escalade.business.contract.manager.UserManager;

public class ManagerFactoryImpl implements ManagerFactory {
	private CommentaireManager commentaireManager;
	private CotationManager cotationManager;
	private LieuManager lieuManager;
	private ReservationManager reservationManager;
	private RoleManager roleManager;
	private SiteManager siteManager;
	private TopoManager topoManager;
	private UserManager userManager;

	@Override
	public CommentaireManager getCommentaireManager() {
		return this.commentaireManager;
	}

	@Override
	public void setCommentaireManager(CommentaireManager pCommentaireManager) {
		this.commentaireManager = pCommentaireManager;		
	}
	
	@Override
	public CotationManager getCotationManager() {
		return this.cotationManager;
	}

	@Override
	public void setCotationManager(CotationManager pCotationManager) {
		this.cotationManager = pCotationManager;		
	}
	
	@Override
	public LieuManager getLieuManager() {
		return this.lieuManager;
	}

	@Override
	public void setLieuManager(LieuManager pLieuManager) {
		this.lieuManager = pLieuManager;		
	}

	@Override
	public ReservationManager getReservationManager() {
		return this.reservationManager;
	}

	@Override
	public void setReservationManager(ReservationManager pReservationManager) {
		this.reservationManager = pReservationManager;
	}
	
	@Override
	public RoleManager getRoleManager() {
		return this.roleManager;
	}
	
	@Override
	public void setRoleManager(RoleManager pRoleManager) {
		this.roleManager = pRoleManager;
	}

	@Override
	public SiteManager getSiteManager() {
		return this.siteManager;
	}

	@Override
	public void setSiteManager(SiteManager pSiteManager) {
		this.siteManager = pSiteManager;
	}

	@Override
	public TopoManager getTopoManager() {
		return this.topoManager;
	}

	@Override
	public void setTopoManager(TopoManager pTopoManager) {
		this.topoManager = pTopoManager;
	}

	@Override
	public UserManager getUserManager() {
		return this.userManager;
	}

	@Override
	public void setUserManager(UserManager pUserManager) {
		this.userManager = pUserManager;
	}
}
