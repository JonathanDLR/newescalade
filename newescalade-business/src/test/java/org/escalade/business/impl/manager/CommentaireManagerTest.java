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

public class CommentaireManagerTest extends TestCase {
	private CommentaireManagerImpl commentaireManagerImpl;
	private int pId;
	
	@Before
	public void setUp() {
		commentaireManagerImpl = new CommentaireManagerImpl();
	}
	
	@After
	public void tearDown() {
		pId = 0;
	}
	
	@Test
	public void testGetCommentWithBadId() {
		try {
			commentaireManagerImpl.getCommentaireById(pId);
			
			fail("Expected NotFoundException not thrown");
		} catch (NotFoundException e) {
			assertThat(e.getMessage(), is("Commentaire non trouvé : numero = " + pId));
		}		
	}
}
