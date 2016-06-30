package com.github.adolfojunior.framework.jaxrs;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * This class will register any Bean annotated with {@link Path} or {@link Provider}.
 */
public abstract class JaxrsResourceAutoConfig extends ResourceConfig
    implements ApplicationContextAware {

  private static final Logger LOGGER = LoggerFactory.getLogger(JaxrsResourceAutoConfig.class);

  private ApplicationContext applicationContext;

  public ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  @PostConstruct
  public void load() {
    getJaxrsProviderBeans().entrySet().forEach(entry -> {
      LOGGER.info("JAX-RS Register @Provider bean {} of type", entry.getKey());
      register(entry.getValue());
    });
    getJaxrsPathBeans().entrySet().forEach(entry -> {
      LOGGER.info("JAX-RS Register @Path bean {} of type", entry.getKey());
      register(entry.getValue());
    });
  }

  protected Map<String, Object> getJaxrsPathBeans() {
    return getApplicationContext().getBeansWithAnnotation(Path.class);
  }

  protected Map<String, Object> getJaxrsProviderBeans() {
    return getApplicationContext().getBeansWithAnnotation(Provider.class);
  }
}
