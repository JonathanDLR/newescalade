package org.escalade.consumer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.escalade.consumer.impl.dao.LieuDaoImpl;
import org.escalade.model.beans.Lieu;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "**/consumerContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class LieuDaoTest {
	@Autowired
	private LieuDaoImpl lieuDao;
	
	private Lieu lieu;
	
	@Before
	public void setUp() {
		lieu = new Lieu();
	}
	
	@After
	public void tearDown() {
		lieu = null;
	}
	
	@Test
	public void testGetLieuById() {
		int id = lieuDao.createLieu(lieu);
		Lieu newLieu = lieuDao.getLieuById(id);
		assertNotNull(newLieu);
		assertEquals(id, newLieu.getId());
	}
	
	@Test
	public void testGetLieuByName() {
		lieu.setName("test");
		lieuDao.createLieu(lieu);
		Lieu newLieu = lieuDao.getLieuByName("test");
		assertNotNull(newLieu);
		assertEquals("test", newLieu.getName());
	}
	
	@Test
	public void testGetAllLieu() {
		lieuDao.createLieu(lieu);
		List<Lieu> lieus = lieuDao.getAllLieu();
		assertEquals(2, lieus.size());
	}
}
