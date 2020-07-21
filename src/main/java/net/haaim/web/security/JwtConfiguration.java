package net.haaim.web.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.jwt")
public class JwtConfiguration {
	private String secret;
	private long expiration;
}
