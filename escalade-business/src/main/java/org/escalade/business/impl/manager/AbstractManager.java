package org.escalade.business.impl.manager;

public class AbstractManager {
	private static DaoFactory daoFactory;
	
	protected static DaoFactory getDaoFactory() {
		return daoFactory;
	}
	
	public static void setDaoFactory(DaoFactory pDaoFactory) {
		daoFactory = pDaoFactory;
	}
}
