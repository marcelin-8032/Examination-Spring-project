package com.examination.project.infrastructure.configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI infoDocs() {
        return new OpenAPI()
                .info(new Info()
                        .title("Examination app")
                        .description("application of examination management")
                        .version("1.0.0")
                        .license(new License().name("Apache License Version 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0\""))
                        .contact(new Contact().name("Marcel")
                                .url("https://")
                                .email("email@gmail.com"))
                );
    }

    @Bean
    public GroupedOpenApi groupedOpenApiV1() {
        return GroupedOpenApi.builder()
                .group("Examination-v1")
                .pathsToMatch("/v1/**")
                .build();
    }

    @Bean
    public GroupedOpenApi groupedOpenApiV2() {
        return GroupedOpenApi.builder()
                .group("Examination-v2")
                .pathsToMatch("/v2/**")
                .build();
    }
}
