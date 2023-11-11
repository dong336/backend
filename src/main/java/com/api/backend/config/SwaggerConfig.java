package com.api.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI() {
        Info info = new Info()
                .title("Spring API Document")
                .version("v1.0.0")
                .description("백엔드 API 명세서입니다.");
        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
