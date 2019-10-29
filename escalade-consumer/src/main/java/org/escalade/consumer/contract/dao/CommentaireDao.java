package org.escalade.consumer.contract.dao;

import org.escalade.model.beans.Commentaire;

public interface CommentaireDao {
	void createCom(Commentaire pCommentaire);
	void deleteCom(int pId);
}
