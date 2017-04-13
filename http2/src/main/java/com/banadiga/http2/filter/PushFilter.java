package com.banadiga.http2.filter;

import org.eclipse.jetty.server.PushBuilder;
import org.eclipse.jetty.server.Request;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

@Component
public class PushFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    String uri = httpRequest.getRequestURI();
    switch (uri) {
      case "/index.html":
        PushBuilder pushBuilder = Request.getBaseRequest(request).getPushBuilder();
        for (int i = 4; i <= 5; i++) {
          for (int j = 1; j <= 20; j++) {
            pushBuilder.path("/" + i + "/" + j + ".jpg").push();
          }
        }
        pushBuilder.path("/application.js").push();
        break;
      default:
        break;
    }
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {

  }
}
