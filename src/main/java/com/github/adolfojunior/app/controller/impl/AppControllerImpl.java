package com.github.adolfojunior.app.controller.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.github.adolfojunior.app.ApplicationInfo;
import com.github.adolfojunior.app.controller.AppController;

@Controller
public class AppControllerImpl implements AppController {

  private ApplicationInfo info;

  @Inject
  public AppControllerImpl(ApplicationInfo info) {
    this.info = info;
  }

  @Override
  public ApplicationInfo getInfo() {
    return this.info;
  }
}
