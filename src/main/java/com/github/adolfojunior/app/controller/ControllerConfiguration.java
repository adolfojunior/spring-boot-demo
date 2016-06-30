package com.github.adolfojunior.app.controller;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfiguration {

  @Bean
  public ResourceConfig getResourceConfiguration() {
    return new ControllerResourceConfig();
  }
}
