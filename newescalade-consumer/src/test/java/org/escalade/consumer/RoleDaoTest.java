package org.escalade.consumer;

import org.escalade.consumer.impl.dao.RoleDaoImpl;
import org.escalade.model.beans.Role;
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
public class RoleDaoTest extends TestCase {
	@Autowired
	private RoleDaoImpl roleDao;
	
	private Role role;
	
	@Before
	public void setUp() {
		role = new Role();
	}
	
	@After
	public void tearDown() {
		role = null;
	}
	
	@Test
	public void testGetRoleById() {
		int id = roleDao.createRole(role);
		Role newRole = roleDao.getRoleById(id);
		assertNotNull(newRole);
		assertEquals(id, newRole.getId());
	}
}
