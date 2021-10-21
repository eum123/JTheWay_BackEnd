package net.haaim.web.api.common.swagger;

import org.springframework.context.annotation.Configuration;

//@OpenAPIDefinition( 
//		info = @Info(title = "lolien-discord-bot API 명세서"
//			, description = "API 명세서", version = "v1"
//			, contact = @Contact(name = "webgori", email = "webgori@gmail.com")
//		, license = @License(name = "Apache 2.0"
//			, url = "http://www.apache.org/licenses/LICENSE-2.0.html") 
//		) ,
//		security = @io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "basic")
//		,servers = @io.swagger.v3.oas.annotations.servers.Server(url="http://localhost:8080", description = "api")
//)

//@Configuration
public class SwaggerConfig {
	
//	@Bean
//	public OpenAPI openAPI(@Value("${spring.profiles.active}") String active) {
//		Info info = new Info()
//				.title("title")
//				.version("1.0.0")
//				.description("description")
//				.termsOfService("http://swagger.io/terms/")
//				;
//		List<Server> servers = Arrays.asList(new Server().url("http://localhost:8080").description("api " + active));
//		
//		SecurityScheme basicScheme = new SecurityScheme()
//				.type(SecurityScheme.Type.HTTP)
//				.scheme("basic");
//		
//		SecurityRequirement securityItem = new SecurityRequirement()
//				.addList("basicAuth");
//		
//		return new OpenAPI()
//				.components(new Components().addSecuritySchemes("basicAuth", basicScheme))
//				.addSecurityItem(securityItem)
//				.info(info)
//				.servers(servers)
//				;
//	}
	
//	@Bean
//	  public GroupedOpenApi customGameOpenApi() {
//	    String[] paths = {"/system/menu/**"};
//	    return GroupedOpenApi.builder().setGroup("내전 관련 API").pathsToMatch(paths)
//	        .build();
//	  }
}
