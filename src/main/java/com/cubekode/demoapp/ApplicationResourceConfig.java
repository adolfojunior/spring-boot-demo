package com.cubekode.demoapp;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;

import org.springframework.stereotype.Component;

import com.cubekode.demoapp.jaxrs.JaxrsResourceAutoConfig;
import com.cubekode.demoapp.jaxrs.JaxrsResources;

@Component
@ApplicationPath("/api")
public class ApplicationResourceConfig extends JaxrsResourceAutoConfig {

	@Inject
	public ApplicationResourceConfig(JaxrsResources jaxrsResources) {
		super(jaxrsResources);
	}
}
