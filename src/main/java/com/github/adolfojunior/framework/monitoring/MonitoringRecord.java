package com.github.adolfojunior.framework.monitoring;

import java.util.Date;

public class MonitoringRecord {

  private String name;
  private long timestamp;
  private long duration;
  private Throwable error;

  public MonitoringRecord(String name) {
    this.name = name;
    this.timestamp = System.currentTimeMillis();
    this.duration = -1;
  }

  public String getName() {
    return name;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public long getDuration() {
    return duration;
  }

  public Throwable getError() {
    return error;
  }

  public void stop() {
    this.duration = System.currentTimeMillis() - this.timestamp;
  }

  public void stopWithError(Throwable error) {
    this.stop();
    this.error = error;
  }

  @Override
  public String toString() {
    return String.format("[%s](%s)(%sms)", new Date(this.timestamp), this.name, this.duration);
  }
}
