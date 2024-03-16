package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {

	private final QuteService quteService;

	public MyController(QuteService quteService) {
		this.quteService = quteService;
	}

	@GetMapping(value = "/greeting", produces = "text/html")
	@ResponseBody
	public String greeting() {
		Map<String, Object> data = new HashMap<>();
		data.put("name", "World");
		return quteService.render("greeting", data);
	}

	@GetMapping(value = "/now", produces = "text/html")
	@ResponseBody
	public String now() {
		Map<String, Object> data = new HashMap<>();
		LocalDateTime now = LocalDateTime.now();
		data.put("now", now);
		data.put("bla", "blabla");
		return quteService.render("now", data);
	}

	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "index";
	}
}
