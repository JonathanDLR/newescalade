package org.escalade.webapp.servlets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.apache.log4j.Logger;
import org.escalade.model.beans.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import junit.framework.TestCase;

@ContextConfiguration(locations = { "**/WEB-INF/spring-servlet.xml", "classpath:/bootstrapContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ConnexionServletTest extends TestCase {
	protected static Logger logger = Logger.getLogger(ConnexionServletTest.class);
	private User user;
	private ConnexionServlet connexionServlet;
	
	@Autowired
	private WebApplicationContext context;	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
		connexionServlet = new ConnexionServlet();
		mockMvc = MockMvcBuilders.standaloneSetup(connexionServlet)
								 .setViewResolvers(viewResolver)
								 .build();
//		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		user = new User();
	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		user = null;
	}
	
	@Test
	public void testUserLoginNotNull() throws Exception {
		user.setLogin("");
		mockMvc.perform(post("/connexion").flashAttr("userForm", user))
			   .andExpect(view().name("connexion"))
			   .andExpect(model().attributeHasFieldErrorCode("userForm", "login", "error.mailEmpty"))
			   .andDo(print());		
	}
	
	@Test
	public void testUserLoginInvalid() throws Exception {
		user.setLogin("test");
		mockMvc.perform(post("/connexion").flashAttr("userForm", user))
			   .andExpect(view().name("connexion"))
			   .andExpect(model().attributeHasFieldErrorCode("userForm", "login", "error.mailNotValid"))
			   .andDo(print());		
	}
	
	@Test
	public void testUserPswdNotNull() throws Exception {
		user.setLogin("test@test.fr");
		mockMvc.perform(post("/connexion").flashAttr("userForm", user))
			   .andExpect(view().name("connexion"))
			   .andExpect(model().attributeHasFieldErrorCode("userForm", "pswd", "error.pswdEmpty"))
			   .andDo(print());		
	}
	
	@Test
	public void testUserPswdNotValid() throws Exception {
		user.setLogin("test@test.fr");
		user.setPswd("test");
		mockMvc.perform(post("/connexion").flashAttr("userForm", user))
			   .andExpect(view().name("connexion"))
			   .andExpect(model().attributeHasFieldErrorCode("userForm", "pswd", "error.pswdNotValid"))
			   .andDo(print());		
	}
	
	@Test
	public void testUserValid() throws Exception {
		user.setLogin("test@test.fr");
		user.setPswd("Test95");
		mockMvc.perform(post("/connexion").flashAttr("userForm", user))
			   .andExpect(view().name("connexion"))
			   .andExpect(model().attributeHasNoErrors("userForm"))
			   .andDo(print());		
	}
}
