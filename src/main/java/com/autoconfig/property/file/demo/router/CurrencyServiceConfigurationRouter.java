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
            .build();
    }
}
