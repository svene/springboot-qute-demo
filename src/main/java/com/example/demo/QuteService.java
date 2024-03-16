package com.example.demo;

import io.quarkus.qute.Engine;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class QuteService {

	private final Engine engine;

	public QuteService(Engine engine) {
		this.engine = engine;
	}

	public String render(String templateName, Map<String, Object> data) {
		Template template = engine.getTemplate(templateName);
		TemplateInstance instance = template.data(data);
		return instance.render();
	}
}
