package com.github.adolfojunior.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.github.adolfojunior.framework.monitoring.MonitoringConfiguration;

@SpringBootApplication
@Import({MonitoringConfiguration.class})
public class ApplicationBootstrap {

  public static void main(String[] args) {
    SpringApplication.run(ApplicationBootstrap.class, args);
  }
}
