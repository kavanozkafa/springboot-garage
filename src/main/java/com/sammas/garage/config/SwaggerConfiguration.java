package com.sammas.garage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

	
	@Bean
	public Docket swagger() {

	
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.sammas.garage"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() { 
		return new ApiInfoBuilder()
				.title("Garage Parking REST API")
				.description("Garage API Documentation")
				.termsOfServiceUrl("https://opensource.org/licenses/MIT")
				.license("MIT License")
				.licenseUrl("https://opensource.org/licenses/MIT")
				.version("1.0")
				.contact(new Contact("Şammas Çölkesen", "github.com/kavanozkafa", "sammascolkesen@gmail.com"))
				.build();
	}
	 
}
