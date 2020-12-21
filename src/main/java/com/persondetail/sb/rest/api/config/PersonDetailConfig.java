package com.persondetail.sb.rest.api.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class PersonDetailConfig {
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Java Learn").apiInfo(apiInfo()).select()
				.paths(regex("/person.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Person Details Service")
				.description("Sample Documentation Generateed Using SWAGGER2 for our Person Details Service Rest API")
				.termsOfServiceUrl("Person Details Service")
				.licenseUrl("Person Details Service").version("1.0").build();
	}

}
