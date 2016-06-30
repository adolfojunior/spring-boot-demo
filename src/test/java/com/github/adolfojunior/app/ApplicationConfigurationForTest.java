package com.github.adolfojunior.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.github.adolfojunior.app.ApplicationBootstrap;

@Configuration
@Import(ApplicationBootstrap.class)
public class ApplicationConfigurationForTest {
}
