package org.escalade.business.contract.manager;

import org.escalade.model.beans.Topo;

public interface TopoManager {
	Topo getTopoByName(String pName);
	void createTopo(Topo pTopo);
}
