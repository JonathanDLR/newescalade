package org.escalade.business.impl.manager;

import org.escalade.consumer.contract.dao.DaoFactory;

public class AbstractManager {
	private static DaoFactory daoFactory;
	
	protected static DaoFactory getDaoFactory() {
		return daoFactory;
	}
	
	public static void setDaoFactory(DaoFactory pDaoFactory) {
		daoFactory = pDaoFactory;
	}
}
