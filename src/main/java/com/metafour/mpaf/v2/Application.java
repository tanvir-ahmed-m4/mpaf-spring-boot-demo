package com.metafour.mpaf.v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import com.sun.xml.ws.transport.http.servlet.WSSpringServlet;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@ImportResource("/jaxws-spring-context.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new WSSpringServlet(),"/jaxws-spring/*");
    }
}

