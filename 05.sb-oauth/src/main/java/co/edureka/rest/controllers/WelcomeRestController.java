package co.edureka.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		return "Welcome to Edureka!";
	}
}
