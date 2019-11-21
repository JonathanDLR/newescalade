package org.escalade.consumer;

import org.escalade.consumer.impl.dao.CommentaireDaoImpl;
import org.escalade.model.beans.Commentaire;
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
public class CommentaireDaoTest extends TestCase {
	@Autowired
	private CommentaireDaoImpl commentaireDao;
	
	private Commentaire commentaire;
	
	@Before
	public void setUp() {
		commentaire = new Commentaire();
	}
	
	@After
	public void tearDown() {
		commentaire = null;
	}
	
	@Test
	public void testGetCommentaireById() {
		int id = commentaireDao.createCom(commentaire);
		Commentaire newCom = commentaireDao.getCommentaireById(id);
		assertNotNull(newCom);
		assertEquals(id, newCom.getId());
	}
}
