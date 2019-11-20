package org.escalade.business.impl.manager;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.escalade.model.exception.NotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class LieuManagerTest extends TestCase {
	private LieuManagerImpl lieuManagerImpl;
	private int pId;
	
	@Before
	public void setUp() {
		lieuManagerImpl = new LieuManagerImpl();
	}
	
	@After
	public void tearDown() {
		pId = 0;
	}
	
	@Test
	public void testGetCommentWithBadId() {
		try {
			lieuManagerImpl.getLieuById(pId);
			
			fail("Expected NotFoundException not thrown");
		} catch (NotFoundException e) {
			assertThat(e.getMessage(), is("Lieu non trouvé : numero = " + pId));
		}
	}	
}
