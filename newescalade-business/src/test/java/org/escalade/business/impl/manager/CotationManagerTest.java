package org.escalade.business.impl.manager;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.escalade.model.exception.NotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.TestCase;

public class CotationManagerTest extends TestCase {
	private CotationManagerImpl cotationManagerImpl;
	private int pId;
	
	@Before
	public void setUp() {
		cotationManagerImpl = new CotationManagerImpl();
	}
	
	@After
	public void tearDown() {
		pId = 0;
	}
	
	@Test
	public void testGetCotationWithById() {
		try {
			cotationManagerImpl.getCotationById(pId);
			
			fail("Expected NotFoundException not thrown");
		} catch (NotFoundException e) {
			assertThat(e.getMessage(), is("Cotation non trouvé : numero = " + pId));
		}
		
	}
}
