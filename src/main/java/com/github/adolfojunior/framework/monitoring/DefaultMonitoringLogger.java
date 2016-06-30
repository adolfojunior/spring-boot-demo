package com.github.adolfojunior.framework.monitoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultMonitoringLogger implements MonitoringCollector {

  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMonitoringLogger.class);

  @Override
  public void collect(MonitoringRecord monitoringRecord) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug(monitoringRecord.toString());
    }
  }
}
