package org.escalade.business.contract.manager;

import java.util.List;

import org.escalade.model.beans.Topo;
import org.escalade.model.beans.User;

public interface TopoManager {
	Topo getTopoByName(String pName);
	List<Topo> getTopoDisp(User pUser);
	void createTopo(Topo pTopo, String pName, String pDescription, User pUser);
	void topoToggleDisp(Topo pTopo);
}
