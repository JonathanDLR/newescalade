package org.escalade.consumer;

import java.util.List;

import org.escalade.consumer.impl.dao.SiteDaoImpl;
import org.escalade.model.beans.Cotation;
import org.escalade.model.beans.Lieu;
import org.escalade.model.beans.Site;
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
public class SiteDaoTest extends TestCase {
	@Autowired
	private SiteDaoImpl siteDao;
	private Site site;
	
	@Before
	public void setUp() {
		site = new Site();
	}
	
	@After
	public void tearDown() {
		site = null;
	}
	
	@Test
	public void testGetSiteByNom() {
		site.setNom("testnom");
		siteDao.createSite(site);
		Site newSite = siteDao.getSiteByNom("testnom");
		assertNotNull(newSite);
		assertEquals("testnom", newSite.getNom());
	}
	
	@Test
	public void testGetAllSite() {
		siteDao.createSite(site);
		Lieu pLieu = null;
		Cotation pCot = null;
		int pSecteur = 0;
		List<Site> sites = siteDao.getAllSite(pLieu, pCot, pSecteur);
		assertEquals(1, sites.size());
	}
	
	@Test
	public void testToggleOfficial() {
		site.setNom("test");
		siteDao.createSite(site);
		siteDao.toggleOfficial(site);
		Site newSite = siteDao.getSiteByNom("test");
		assertTrue(newSite.isOfficiel());
	}
}
