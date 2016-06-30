package com.github.adolfojunior.framework.monitoring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MonitoringInterceptor {

  private MonitoringCollector collector;

  public MonitoringInterceptor(MonitoringCollector collector) {
    this.collector = collector;
  }

  @Pointcut("within(@org.springframework.stereotype.Controller *)")
  public void controllerBeans() {}

  @Pointcut("within(@org.springframework.stereotype.Service *)")
  public void serviceBeans() {}

  @Pointcut("within(@org.springframework.stereotype.Repository *)")
  public void repositoryBeans() {}

  @Pointcut("execution(public * *(..))")
  public void publicMethod() {}

  @Around("controllerBeans() && publicMethod()")
  public Object interceptController(ProceedingJoinPoint joinPoint) throws Throwable {
    return intercept(joinPoint);
  }

  @Around("serviceBeans() && publicMethod()")
  public Object interceptService(ProceedingJoinPoint joinPoint) throws Throwable {
    return intercept(joinPoint);
  }

  @Around("repositoryBeans() && publicMethod()")
  public Object interceptRepository(ProceedingJoinPoint joinPoint) throws Throwable {
    return intercept(joinPoint);
  }

  private Object intercept(ProceedingJoinPoint joinPoint) throws Throwable {
    final MonitoringRecord monitoringRecord = new MonitoringRecord(joinPoint.toShortString());
    try {
      final Object returnValue = joinPoint.proceed();
      monitoringRecord.stop();
      return returnValue;
    } catch (Throwable error) {
      monitoringRecord.stopWithError(error);
      throw error;
    } finally {
      collector.collect(monitoringRecord);
    }
  }
}
