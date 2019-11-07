package org.escalade.business.impl.manager;

import java.util.List;

import org.escalade.business.contract.manager.TopoManager;
import org.escalade.model.beans.Topo;
import org.escalade.model.beans.User;

public class TopoManagerImpl extends AbstractManager implements TopoManager {

	@Override
	public void createTopo(Topo pTopo, String pName, String pDescription, User pUser) {	
		// CREATE TOPO
		pTopo.setName(pName);
		pTopo.setDescription(pDescription);
		pTopo.setUser(pUser);
		
		getDaoFactory().getTopoDao().createTopo(pTopo);
	}
	
	@Override
	public void topoToggleDisp(Topo pTopo) {
		getDaoFactory().getTopoDao().topoToggleDisp(pTopo);
	}
	
	@Override
	public Topo getTopoByName(String pName) {
		Topo topo = getDaoFactory().getTopoDao().getTopoByName(pName);
		
		return topo;
	}
	
	@Override
	public List<Topo> getTopoDisp(User pUser) {
		List<Topo> topos = getDaoFactory().getTopoDao().getTopoDisp(pUser);
		
		return topos;
	}

}
