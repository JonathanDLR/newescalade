package org.escalade.business.impl.manager;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.escalade.model.exception.NotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class RoleManagerTest extends TestCase {
	private RoleManagerImpl roleManagerImpl;
	private int pId;
	
	@Before
	public void setUp() {
		roleManagerImpl = new RoleManagerImpl();
	}
	
	@After
	public void tearDown() {
		pId = 0;
	}
	
	@Test
	public void testGetCommentWithBadId() {
		try {
			roleManagerImpl.getRoleById(pId);
			
			fail("Expected NotFoundException not thrown");
		} catch (NotFoundException e) {
			assertThat(e.getMessage(), is("Role non trouvé : numero = " + pId));
		}	
	}
}
