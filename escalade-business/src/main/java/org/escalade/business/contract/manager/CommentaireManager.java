package org.escalade.business.contract.manager;

import org.escalade.model.beans.Commentaire;
import org.escalade.model.beans.Site;
import org.escalade.model.beans.User;

public interface CommentaireManager {
	int createCom(Commentaire pCommentaire, String com, Site pSite, User pUser);
	void updateCom(Commentaire pCommentaire, String com);
	void deleteCom(int pId);
	Commentaire getCommentaireById(int pId);
}
