package com.github.adolfojunior.spring.sample.jaxrs;

import java.util.HashSet;
import java.util.Set;

public class JaxrsResources {

	private Set<Class<?>> resources = new HashSet<>();

	public void addResource(Class<?> type) {
		resources.add(type);
	}

	public Set<Class<?>> getResources() {
		return resources;
	}
}