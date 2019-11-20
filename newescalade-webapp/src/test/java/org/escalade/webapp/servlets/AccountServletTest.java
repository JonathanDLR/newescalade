//package org.escalade.webapp.servlets;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.escalade.model.beans.Topo;
//import org.escalade.model.beans.User;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import junit.framework.TestCase;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "**/WEB-INF/spring-servlet.xml", "classpath:/bootstrapContext.xml" })
//@WebAppConfiguration
//public class AccountServletTest extends TestCase {
//	@Autowired
//	private WebApplicationContext context;	
//	
//	private Topo topo;
//	private AccountServlet accountServlet;
//	private MockMvc mockMvc;
//	private Map<String, Object> session;
//	private User user;
//	
//	@Before
//	public void setUp() throws Exception {
//		super.setUp();
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
//		session = new HashMap<>();
//		user = new User();
//		session.put("user", user);
//		topo = new Topo();
//	}
//	
//	@After
//	public void tearDown() throws Exception {
//		super.tearDown();
//		topo = null;
//	}
//	
//	@Test
//	public void testTopoNameNotNull() throws Exception {
//		mockMvc.perform(post("/account").sessionAttrs(session)
//		   .flashAttr("topoForm", topo))
//		   .andDo(print())
//		   .andExpect(view().name("account"))
//		   .andExpect(model().attributeHasErrors("topoForm"))
//		   .andDo(print());	
//	}
//}
