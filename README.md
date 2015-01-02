Overview
========
Metafour PAF Service Demo project using Spring Boot.

Change Log
==========
0.0.1-M1
--------
Spring Boot with two RESTfull service endpoints:

*   http://localhost:8080/address/GB/W148EZ/part
*   http://localhost:8080/address/GB/W148EZ/full

Both returns JSON data by default or if Accept header is application/json.

Both returns HTTP error code 406 (Not Acceptable) if Accept header is application/xml or text/xml.

0.0.1-M2
--------
Both JSON and XML services are working... thanks to @XmlRootElement annotation on bean classes.

0.0.1-M3
--------
JAX-WS SOAP services (**Code First**) with Spring Boot. 

0.0.1-M4
--------
Use a SOAPHandler and logging with Spring Boot.

JAX-WS commons - Spring support for JAX-WS RI - Project Kenai:

*   https://jax-ws-commons.java.net/spring/
*   http://examples.javacodegeeks.com/enterprise-java/jws/jax-ws-spring-integration-example/
*   http://docs.spring.io/autorepo/docs/spring-boot/current-SNAPSHOT/reference/html/howto-traditional-deployment.html
*   http://stackoverflow.com/questions/20915528/how-can-i-register-a-secondary-servlet-with-spring-boot
*   http://stackoverflow.com/questions/21470409/spring-boot-how-do-i-reference-application-properties-in-an-importresource
*   http://docs.spring.io/spring-boot/docs/current/reference/html/howto-logging.html
