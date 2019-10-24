package org.escalade.consumer.contract.dao;

import java.util.List;

import org.escalade.model.beans.Topo;
import org.escalade.model.beans.User;

public interface TopoDao {
	void createTopo(Topo pTopo);
	Topo getTopoByName(String pName);
	List<Topo> getTopoDisp(User pUser);
}
