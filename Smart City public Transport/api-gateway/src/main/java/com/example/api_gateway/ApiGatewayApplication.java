package com.example.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/api/users/**","/auth/**")
                        .uri("http://localhost:5001"))
                .route("course-service", r -> r.path("/api/courses/**")
                        .uri("http://localhost:5002"))
                .route("classroom-service", r -> r.path("/api/classrooms/**")
                        .uri("http://localhost:5003"))
                .route("assessment-service", r -> r.path("/api/assessments/**")
                        .uri("http://localhost:5004"))
                .route("notification-service", r -> r.path("/api/notifications/**")
                        .uri("http://localhost:5005"))
                .build();
    }
}