package net.haaim.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class JTheWayWebApplication {
	public static void main(String ...args) {
		SpringApplication.run(JTheWayWebApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(JTheWayWebApplication.class);
	}
}
