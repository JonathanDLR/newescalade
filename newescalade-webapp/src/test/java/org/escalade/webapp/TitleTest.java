package org.escalade.webapp;

import static net.sourceforge.jwebunit.junit.JWebUnit.assertLinkPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.clickLink;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;
import static net.sourceforge.jwebunit.junit.JWebUnit.setTestingEngineKey;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.util.TestingEngineRegistry;

public class TitleTest {
	@Before
	public void prepare() {
		setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
		setBaseUrl("http://localhost:8080/escalade-webapp");
	}
	
	@Test
	public void testConnexionPage() {
		beginAt("connexion");
		assertTitleEquals("Amis Escalade: Connexion");
		assertLinkPresent("inscriptionlink");
		clickLink("inscriptionlink");
		assertTitleEquals("Amis Escalade: Inscription");
	}
}
