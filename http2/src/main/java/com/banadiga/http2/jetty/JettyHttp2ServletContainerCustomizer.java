package com.banadiga.http2.jetty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.stereotype.Component;

@Component
public class JettyHttp2ServletContainerCustomizer implements EmbeddedServletContainerCustomizer {

  private final JettyHttp2ServerCustomizer jettyHttp2ServerCustomizer;

  @Autowired
  public JettyHttp2ServletContainerCustomizer(JettyHttp2ServerCustomizer jettyHttp2ServerCustomizer) {
    this.jettyHttp2ServerCustomizer = jettyHttp2ServerCustomizer;
  }

  @Override
  public void customize(ConfigurableEmbeddedServletContainer container) {
    JettyEmbeddedServletContainerFactory factory = (JettyEmbeddedServletContainerFactory) container;
    factory.addServerCustomizers(jettyHttp2ServerCustomizer);
  }
}
