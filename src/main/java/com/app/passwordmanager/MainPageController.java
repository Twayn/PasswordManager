package com.app.passwordmanager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

	@Value("${generate.password:test}")
	private String password = "password";

	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		model.put("password", this.password);
		return "index";
	}

}