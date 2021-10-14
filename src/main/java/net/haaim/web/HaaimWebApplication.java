package net.haaim.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@MapperScan(basePackages = "net.haaim.web.api")
public class HaaimWebApplication {
	public static void main(String ...args) {
		SpringApplication.run(HaaimWebApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HaaimWebApplication.class);
	}
}
