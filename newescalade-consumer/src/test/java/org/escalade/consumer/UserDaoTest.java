package org.escalade.consumer;

import org.escalade.consumer.impl.dao.UserDaoImpl;
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
public class UserDaoTest extends TestCase {
	@Autowired
	private UserDaoImpl userDao;
	private User user;
	
	@Before
	public void setUp() {
		user = new User();
	}
	
	@After
	public void tearDown() {
		user = null;
	}
	
	@Test
	public void testGetUserByLogin() {
		user.setLogin("test");
		userDao.createUser(user);
		User newUser = userDao.getUserByLogin("test");
		assertNotNull(newUser);
		assertEquals("test", newUser.getLogin());
	}
}
