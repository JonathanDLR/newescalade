package org.escalade.webapp.bootstrap;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("org.eescalade")
@ImportResource("classpath:/applicationContext.xml")
public class SpringConfiguration {

}
