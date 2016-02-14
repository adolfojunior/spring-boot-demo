package com.cubekode.demoapp.jaxrs;

import java.util.Collection;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

/**
 * Lookup for JAX-RS implementations Beans.
 */
@Configuration
public class JaxrsResourceConfiguration {

	@Autowired
	private Environment environment;

	@Autowired
	private ResourceLoader resourceLoader;

	@Bean
	public JaxrsResources jaxrsResources(BeanFactory beanFactory) throws ClassNotFoundException {

		final JaxrsResources resources = new JaxrsResources();
		final ClassPathScanningCandidateComponentProvider scanner = getResourceScanner();

		for (String basePackage : getMappingBasePackages(beanFactory)) {
			for (BeanDefinition candidate : scanner.findCandidateComponents(basePackage)) {
				resources.addResource(getCandidateClass(candidate));
			}
		}
		return resources;
	}

	private Class<?> getCandidateClass(BeanDefinition candidate) throws ClassNotFoundException, LinkageError {
		return ClassUtils.forName(candidate.getBeanClassName(), Thread.currentThread().getContextClassLoader());
	}

	private static Collection<String> getMappingBasePackages(BeanFactory beanFactory) {
		return AutoConfigurationPackages.get(beanFactory);
	}

	private ClassPathScanningCandidateComponentProvider getResourceScanner() {

		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);

		scanner.setEnvironment(this.environment);
		scanner.setResourceLoader(this.resourceLoader);
		// filtering JAX-RS
		scanner.addIncludeFilter(new AnnotationTypeFilter(Path.class, false, true));
		scanner.addIncludeFilter(new AnnotationTypeFilter(Provider.class, false, true));

		return scanner;
	}
}