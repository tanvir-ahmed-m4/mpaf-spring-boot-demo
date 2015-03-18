package com.metafour.mpaf.v2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class SimpleCORSFilter implements Filter {
  
  private static final Logger logger = Logger.getLogger(SimpleCORSFilter.class);

  private static final String[] ALLOWED_METHODS = new String[] { "POST", "GET", "OPTIONS", "DELETE" };

  /**
   * https://spring.io/understanding/CORS
   * https://spring.io/guides/gs/rest-service-cors/
   * http://stackoverflow.com/questions/17478731/whats-the-point-of-x-requested-with-header
   * https://developer.mozilla.org/en-US/docs/Web/HTTP/Access_control_CORS
   * http://enable-cors.org/server.html
   * http://enable-cors.org/server_tomcat.html
   * http://www.html5rocks.com/static/images/cors_server_flowchart.png
   * 
   */
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    if (logger.isDebugEnabled()) {
      Enumeration<String> headerNames = request.getHeaderNames();
      while (headerNames.hasMoreElements()) {
        String headerName = headerNames.nextElement();
        Enumeration<String> headerValues = request.getHeaders(headerName);
        while (headerValues.hasMoreElements()) {
          logger.debug(String.format("%s: %s", headerName, headerValues.nextElement()));
        }
      }
    }

    HttpServletResponse response = (HttpServletResponse) res;
    String requestMethod = request.getHeader("Access-Control-Request-Method");
    if (requestMethod != null && "OPTIONS".equals(request.getMethod())) {
      // Pre-flight requests
      for (String s : ALLOWED_METHODS) {
        if (s.equals(requestMethod)) {
          response.setHeader("Access-Control-Allow-Methods", StringUtils.arrayToCommaDelimitedString(ALLOWED_METHODS));
          response.setHeader("Access-Control-Allow-Origin", "*");
          response.setHeader("Access-Control-Max-Age", "3600");
          response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
          break;
        }
      }
    } else {
      // Handling Simple CORS requests
      String origin = request.getHeader("Origin");
      if (origin != null) {
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
      }
    }
    chain.doFilter(req, res);
  }

  public void init(FilterConfig filterConfig) {}

  public void destroy() {}

}
