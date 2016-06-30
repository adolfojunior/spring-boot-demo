package com.github.adolfojunior.framework.monitoring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MonitoringConfiguration {

  @Bean
  public MonitoringCollector monitoringCollector() {
    return new DefaultMonitoringLogger();
  }

  @Bean
  public MonitoringInterceptor monitoringInterceptor(MonitoringCollector collector) {
    return new MonitoringInterceptor(collector);
  }
}
