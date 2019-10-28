package org.escalade.business.contract.manager;

import org.escalade.model.beans.Commentaire;
import org.escalade.model.beans.Site;
import org.escalade.model.beans.User;

public interface CommentaireManager {
	void createCom(Commentaire pCommentaire, String com, Site pSite, User pUser);
}
