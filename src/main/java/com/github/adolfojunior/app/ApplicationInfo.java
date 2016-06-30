package com.github.adolfojunior.app;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInfo {

  private static final String APP_NAME = "${spring.application.name}";
  private static final String APP_VERSION = "${spring.application.version}";

  private String name;
  private String version;

  @Inject
  public ApplicationInfo(@Value(APP_NAME) String name, @Value(APP_VERSION) String version) {
    this.name = name;
    this.version = version;
  }

  public String getName() {
    return name;
  }

  public String getVersion() {
    return version;
  }

  @Override
  public String toString() {
    return String.format("%s-%s", this.name, this.version);
  }
}
