package com.spo.codingchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class WorkForceOptimiserApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkForceOptimiserApplication.class, args);
	}

	
	 @Bean
	    public Docket docket()
	    {
	        return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName()))
	            .paths(PathSelectors.any())
	            .build()
	            .apiInfo(apiInfo());    }
	 
	    
	    
	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("API Documentation for SPO Staff Optimisation service with Swagger")
	                .description("API Documentation for SPO Staff Optimisation service with Swagger")
	                .termsOfServiceUrl("")
	                .contact("")
	                .license("Apache License Version 2.0")
	                .licenseUrl("")
	                .version("1.0")
	                .build();
	    }

}
