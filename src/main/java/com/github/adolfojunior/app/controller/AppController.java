package com.github.adolfojunior.app.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.adolfojunior.app.ApplicationInfo;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public interface AppController {

  @GET
  ApplicationInfo getInfo();
}
