package com.example.salutation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SalutationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalutationApplication.class, args);
	}

	@RestController
	public class SalutationController {
		@GetMapping("/salutation")
		public String getSalutation() {
			return "Bonjour Master DevOps II";
		}
	}
}
