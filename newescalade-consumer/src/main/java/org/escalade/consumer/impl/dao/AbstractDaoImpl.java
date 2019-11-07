package org.escalade.consumer.impl.dao;


import org.hibernate.SessionFactory;


public class AbstractDaoImpl {
	private SessionFactory sessionFactory;

	// GETTERS SETTERS
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
}
