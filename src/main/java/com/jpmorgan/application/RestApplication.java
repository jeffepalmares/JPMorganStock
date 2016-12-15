package com.jpmorgan.application;

import static springfox.documentation.builders.PathSelectors.regex;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan( basePackages = { "com.jpmorgan.rest.api" , "com.jpmorgan.exception" } ) 
public class RestApplication {
	
	private final static Logger logger = Logger.getLogger(RestApplication.class);
	
	public static void main(String[] args) {
		
		logger.info("Starting Application...");
		
		logger.info("Running standAlone Application...");
		StandAloneApp.runStandAlone();
        
		
		logger.info("Starting Rest Api Application");
		
		SpringApplication.run(RestApplication.class, args);
		
		logger.info("Please access http://localhost:8080/swagger-ui.html");
    }

    
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("JPMorganStock")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/.*Api.*"))
                .build();
    }
     
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("JPMorgan Stock WebApi")
                .version("1.0")
                .build();
    }
}
