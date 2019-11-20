package org.escalade.business.impl.manager;

import org.escalade.business.contract.manager.CommentaireManager;
import org.escalade.model.beans.Commentaire;
import org.escalade.model.beans.Site;
import org.escalade.model.beans.User;
import org.escalade.model.exception.NotFoundException;

public class CommentaireManagerImpl extends AbstractManager implements CommentaireManager {
	public int createCom(Commentaire pCommentaire, String pCom, Site pSite, User pUser) {
		pCommentaire.setComm(pCom);
		pCommentaire.setSite(pSite);
		pCommentaire.setUserAuteur(pUser);
		return getDaoFactory().getCommentaireDao().createCom(pCommentaire);
	}
	
	public void updateCom(Commentaire pCommentaire, String pCom) {
		pCommentaire.setComm(pCom);
		getDaoFactory().getCommentaireDao().updateCom(pCommentaire);
	}
	
	public void deleteCom(int pId) {
		getDaoFactory().getCommentaireDao().deleteCom(pId);
	}
	
	public Commentaire getCommentaireById(int pId) throws NotFoundException {
		if (pId < 1L) {
			throw new NotFoundException("Commentaire non trouvé : numero = " + pId);
		} else {
			return getDaoFactory().getCommentaireDao().getCommentaireById(pId);
		}
	}
}
