package com.metafour.mpaf.v2;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.sun.xml.ws.transport.http.servlet.WSSpringServlet;

@Configuration
@ImportResource("classpath:jaxws-spring-context.xml")
class JaxwsConfiguration {

	@Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new WSSpringServlet(),"/services/*");
    }
	
}