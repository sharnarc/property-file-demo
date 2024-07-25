package com.autoconfig.property.file.demo.router;

import com.autoconfig.property.file.demo.handler.CurrencyServiceConfigurationHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@Slf4j
public class CurrencyServiceConfigurationRouter {
    @Bean
    public RouterFunction<ServerResponse> route(CurrencyServiceConfigurationHandler handler) {
        return RouterFunctions
            .route()
            .path("/currency-configurations", builder -> builder
                .GET("", handler::getConfigDetails)

            )
            .path("/user-configurations", builder -> builder
                .GET("", handler::getConfigDetailsForUsers)

            )
            .path("/user-configurationsByvalues", builder -> builder
                .GET("", handler::getConfigDetailsForUsersByValues)

            )
            .path("/user-details/{number}", builder -> builder
                .GET("", handler::getUserDetailsFromReactiveService)

            )
            .path("/project-details/{projectId}", builder -> builder
                .GET("", handler::getProjectDetails)

            )
            .path("/project-details/webclient/{projectId}", builder -> builder
                .GET("", handler::getProjectDetailsViaClient)

            )
            .build();
    }
}
// use webclient to call services
// WebClient is a non-blocking, reactive client for performing HTTP requests.
// Part of the Spring WebFlux module.
// Suitable for reactive, non-blocking applications.

/*RestTemplate is a synchronous client to perform HTTP requests.
It's part of the Spring Web module.
Suitable for traditional, blocking applications.*/