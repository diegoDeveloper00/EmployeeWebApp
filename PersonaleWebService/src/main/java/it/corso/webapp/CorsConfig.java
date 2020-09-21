package it.corso.webapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		
		return new WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("PUT","GET","DELETE","POST")
						.allowedHeaders("*")
						.exposedHeaders("header1", "header2")
						.exposedHeaders("Authorization")
						.exposedHeaders("responseType")
						.exposedHeaders("observe");
//						.allowCredentials(false)
//						.maxAge(3600);
			}
		};
		
	}
	

}
