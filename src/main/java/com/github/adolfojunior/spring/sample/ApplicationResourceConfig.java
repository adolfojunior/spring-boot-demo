package com.github.adolfojunior.spring.sample;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;

import org.springframework.stereotype.Component;

import com.github.adolfojunior.spring.sample.jaxrs.JaxrsResourceAutoConfig;
import com.github.adolfojunior.spring.sample.jaxrs.JaxrsResources;

@Component
@ApplicationPath("/api")
public class ApplicationResourceConfig extends JaxrsResourceAutoConfig {

  @Inject
  public ApplicationResourceConfig(JaxrsResources jaxrsResources) {
    super(jaxrsResources);
  }
}
