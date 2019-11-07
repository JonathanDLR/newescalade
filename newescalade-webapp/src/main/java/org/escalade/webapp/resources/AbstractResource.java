package org.escalade.webapp.resources;

import org.escalade.business.contract.manager.ManagerFactory;

public class AbstractResource {	
	private static ManagerFactory managerFactory;
	
	protected static ManagerFactory getManagerFactory() {
		return managerFactory;
	}
	
	public static void setManagerFactory(ManagerFactory pManagerFactory) {
		managerFactory = pManagerFactory;
	}
}
