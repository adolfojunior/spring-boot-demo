package com.example;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class DemohResourceConfig extends ResourceConfig {

	public DemohResourceConfig() {
		register(ApplicationApi.class);
	}
}
