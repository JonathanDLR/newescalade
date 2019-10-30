package org.escalade.business.impl.manager;

import org.escalade.business.contract.manager.CommentaireManager;
import org.escalade.model.beans.Commentaire;
import org.escalade.model.beans.Site;
import org.escalade.model.beans.User;

public class CommentaireManagerImpl extends AbstractManager implements CommentaireManager {
	public int createCom(Commentaire pCommentaire, String pCom, Site pSite, User pUser) {
		pCommentaire.setComm(pCom);
		pCommentaire.setSite(pSite);
		pCommentaire.setUserAuteur(pUser);
		return getDaoFactory().getCommentaireDao().createCom(pCommentaire);
	}
	
	public void deleteCom(int pId) {
		getDaoFactory().getCommentaireDao().deleteCom(pId);
	}
}
