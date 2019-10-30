package org.escalade.consumer.contract.dao;

import org.escalade.model.beans.Commentaire;

public interface CommentaireDao {
	int createCom(Commentaire pCommentaire);
	void deleteCom(int pId);
}
