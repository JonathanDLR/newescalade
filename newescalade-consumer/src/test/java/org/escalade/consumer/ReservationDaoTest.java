package org.escalade.consumer;

import java.util.List;

import org.escalade.consumer.impl.dao.ReservationDaoImpl;
import org.escalade.consumer.impl.dao.TopoDaoImpl;
import org.escalade.consumer.impl.dao.UserDaoImpl;
import org.escalade.model.beans.Reservation;
import org.escalade.model.beans.Topo;
import org.escalade.model.beans.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

@ContextConfiguration(locations = "**/consumerContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ReservationDaoTest extends TestCase {
	@Autowired
	private ReservationDaoImpl reservationDao;
	@Autowired
	private UserDaoImpl userDao;
	@Autowired
	private TopoDaoImpl topoDao;
	
	private Reservation reservation;
	
	@Before
	public void setUp() {
		reservation = new Reservation();
	}
	
	@After
	public void tearDown() {
		reservation = null;
	}
	
	@Test
	public void testGetReservationById() {
		int id = reservationDao.createResa(reservation);
		Reservation newResa = reservationDao.getResaById(id);
		assertNotNull(newResa);
		assertEquals(id, newResa.getId());
	}
	
	@Test
	public void testSetProcessed() {
		int id = reservationDao.createResa(reservation);
		Reservation newResa = reservationDao.getResaById(id);
		reservationDao.setProcessed(newResa);
		Reservation newNewResa = reservationDao.getResaById(id);
		assertTrue(newNewResa.getProcessed());
	}
	
	@Test
	public void testGetReservationByUser() {
		User user = new User();
		Topo topo = new Topo();
		userDao.createUser(user);
		topo.setUser(user);
		topoDao.createTopo(topo);
		reservation.setTopo(topo);		
		reservation.setProcessed(false);
		reservationDao.createResa(reservation);
		List<Reservation> reservations = reservationDao.getReservationByUser(user);
		System.out.print(reservations);
		assertEquals(1, reservations.size());
	}
}
