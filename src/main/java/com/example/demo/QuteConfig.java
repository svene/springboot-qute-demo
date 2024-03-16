package com.example.demo;

import io.quarkus.qute.Engine;
import io.quarkus.qute.TemplateLocator;
import io.quarkus.qute.Variant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Optional;

@Configuration
public class QuteConfig {

	@Bean
	public Engine quteEngine() {
		return Engine.builder().addDefaults().addLocator(this::locate).build();
	}

	private Optional<TemplateLocator.TemplateLocation> locate(String id) {
		String path = "/templates/" + id + ".qute"; // Adjust this path according to your needs
		InputStream stream = getClass().getResourceAsStream(path);
		if (stream == null) {
			return Optional.empty();
		}
		return Optional.of(new TemplateLocator.TemplateLocation() {
			@Override
			public Optional<Variant> getVariant() {
				return Optional.empty(); // You can provide a variant if needed
			}

			@Override
			public Reader read() {
				return new InputStreamReader(stream);
			}
		});	}
}
