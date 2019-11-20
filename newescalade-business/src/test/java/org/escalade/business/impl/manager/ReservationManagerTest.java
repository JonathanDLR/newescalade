package org.escalade.business.impl.manager;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.escalade.model.exception.NotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class ReservationManagerTest extends TestCase {
	private ReservationManagerImpl reservationManagerImpl;
	private int pId;
	
	@Before
	public void setUp() {
		reservationManagerImpl = new ReservationManagerImpl();
	}
	
	@After
	public void tearDown() {
		pId = 0;
	}
	
	@Test
	public void testGetCommentWithBadId() {
		try {
			reservationManagerImpl.getReservationById(pId);
			
			fail("Expected NotFoundException not thrown");
		} catch (NotFoundException e) {
			assertThat(e.getMessage(), is("Réservation non trouvée : numero = " + pId));
		}	
	}
}
