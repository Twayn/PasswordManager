package com.app.passwordmanager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainPageController {

	@Value("${generate.password:test}")
	private String password = "password";

	@GetMapping("/")
	public String get(Map<String, Object> model) {
		model.put("password", this.password);
		return "index";
	}

	@PostMapping("/")
	public String post(@ModelAttribute Account account, Map<String, Object> model) throws Exception {
		var transformer = new AccountToPasswordTransformer(account);
		model.put("password", transformer.password());
		return "index";
	}
}