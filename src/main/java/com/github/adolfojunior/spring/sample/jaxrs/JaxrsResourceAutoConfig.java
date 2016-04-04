package com.github.adolfojunior.spring.sample.jaxrs;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provide an autodiscovery service for REST endpoints to Spring.
 */
public abstract class JaxrsResourceAutoConfig extends ResourceConfig {

  private static Logger LOGGER = LoggerFactory.getLogger(JaxrsResourceAutoConfig.class);

  private JaxrsResources jaxrsResources;

  @Inject
  public JaxrsResourceAutoConfig(JaxrsResources jaxrsResources) {
    this.jaxrsResources = jaxrsResources;
  }

  @PostConstruct
  protected void registerDiscoveredResources() {
    jaxrsResources.getResources().stream().forEach(type -> {
      LOGGER.info("Registering JAXRS class {}", type);
      register(type);
    });
  }
}
