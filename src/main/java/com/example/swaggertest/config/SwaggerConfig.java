package com.example.swaggertest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createApi(){
        return new Docket(DocumentationType.OAS_30)
                .groupName("Shawn")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.swaggertest.controller"))
                .build()
                .apiInfo(createApiInfo());
    }


    private ApiInfo createApiInfo(){
        return new ApiInfo(
                "Swagger3 Demo",
                "A simple demo of swagger3 configuration and annotation",
                "v1.0",
                "http://www.shawnDeveloper.ca",
                new Contact("Shawn Huang","http://www.shawnDeveloper.ca","hawkhxf2000@gmail.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
                );
    }
}
