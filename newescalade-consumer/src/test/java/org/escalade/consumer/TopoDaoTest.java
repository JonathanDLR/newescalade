package org.escalade.consumer;

import java.util.List;

import org.escalade.consumer.impl.dao.TopoDaoImpl;
import org.escalade.consumer.impl.dao.UserDaoImpl;
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
public class TopoDaoTest extends TestCase {
	@Autowired
	private TopoDaoImpl topoDao;
	@Autowired
	private UserDaoImpl userDao;
	private Topo topo;
	
	@Before
	public void setUp() {
		topo = new Topo();
	}
	
	@After
	public void tearDown() {
		topo = null;
	}
	
	@Test
	public void testGetTopoByName() {
		topo.setName("testname");
		topoDao.createTopo(topo);
		Topo newTopo = topoDao.getTopoByName("testname");
		assertNotNull(newTopo);
		assertEquals("testname", newTopo.getName());
	}
	
	@Test
	public void testToggleDispo() {
		topo.setName("testtoggle");
		topoDao.createTopo(topo);
		topoDao.topoToggleDisp(topo);
		Topo newTopo = topoDao.getTopoByName("testtoggle");
		assertTrue(newTopo.isDisponible());
	}
	
	@Test
	public void testGetTopoDispo() {
		User user = new User();
		User userTopo = new User();
		userDao.createUser(user);
		userDao.createUser(userTopo);
		topo.setDisponible(true);
		topo.setUser(userTopo);
		topoDao.createTopo(topo);
		List<Topo> topos = topoDao.getTopoDisp(user);
		assertEquals(1, topos.size());
	}
}
