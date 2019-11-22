package org.escalade.consumer;

import java.util.List;

import org.escalade.consumer.impl.dao.CotationDaoImpl;
import org.escalade.model.beans.Cotation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

@ContextConfiguration(locations = "**/consumerContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CotationDaoTest extends TestCase {
	@Autowired
	private CotationDaoImpl cotationDao;
	
	private Cotation cotation;
	
	@Before
	public void setUp() {
		cotation = new Cotation();
	}
	
	@After
	public void tearDown() {
		cotation = null;
	}
	
	@Test
	@Rollback(true)
	public void testGetCotationById() {
		int id = cotationDao.createCotation(cotation);
		Cotation newCotation = cotationDao.getCotationById(id);
		assertNotNull(newCotation);
		assertEquals(id, newCotation.getId());
	}
	
	@Test
	@Rollback(true)
	public void testGetCotationByCot() {
		cotation.setCot("test");
		cotationDao.createCotation(cotation);
		Cotation newCotation = cotationDao.getCotationByCot("test");
		assertNotNull(newCotation);
		assertEquals("test", newCotation.getCot());
	}
	
	@Test
	@Rollback(true)
	public void testGetAllCot() {
		cotationDao.createCotation(cotation);
		List<Cotation> cotations = cotationDao.getAllCot();
		assertEquals(2, cotations.size());
	}
}
