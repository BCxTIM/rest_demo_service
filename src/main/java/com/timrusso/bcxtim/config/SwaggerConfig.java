package com.timrusso.bcxtim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.PathSelectors.any;

@Configuration
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
public class SwaggerConfig {

    @Bean
    public Docket bookApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.timrusso.bcxtim.controller")) //define specific package
//                .apis(RequestHandlerSelectors.any()) //define all packages
//                .paths(regex("/book.*")) //only book controller and model in the package above
                .paths(any()) //any controllers and models in the package above
                .build()
                .apiInfo(getApiInfo());
    }


    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "REST Demo Application",
                "Application to improve some different skills",
                "1.0",
                "http://point.md",
                new Contact("Tim", "http://point.md", "tim@tim.com"),
                "20.0",
                "http://point.md",
                Collections.emptyList()
        );
    }


}
