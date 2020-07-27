package net.haaim.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class HaaimWebApplication {
	public static void main(String ...args) {
		SpringApplication.run(HaaimWebApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HaaimWebApplication.class);
	}
}
