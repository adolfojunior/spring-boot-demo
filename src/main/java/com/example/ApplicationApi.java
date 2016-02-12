package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Path("/")
public class ApplicationApi {

	@Value("${spring.application.name}")
	private String name;

	@Value("${spring.application.version}")
	private String version;

	@GET
	public String get() {
		return name + "#" + version;
	}
}
