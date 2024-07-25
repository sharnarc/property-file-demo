package com.autoconfig.property.file.demo.handler;

import com.autoconfig.property.file.demo.config.CurrencyServiceConfiguration;
import com.autoconfig.property.file.demo.config.CurrencyServiceConfigurationByUsingValue;
import com.autoconfig.property.file.demo.config.UserSearchPublicConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CurrencyServiceConfigurationHandler {

    private final CurrencyServiceConfiguration currencyServiceConfiguration;
    private final UserSearchPublicConfig userSearchPublicConfig;
    private final CurrencyServiceConfigurationByUsingValue configurationByUsingValue;

    public Mono<ServerResponse> getConfigDetails(ServerRequest serverRequest) {

        return ServerResponse.ok().bodyValue(currencyServiceConfiguration);
    }

    public Mono<ServerResponse> getConfigDetailsForUsers(ServerRequest serverRequest) {

        return ServerResponse.ok().bodyValue(userSearchPublicConfig);
    }

    public Mono<ServerResponse> getConfigDetailsForUsersByValues(ServerRequest serverRequest) {

        return ServerResponse.ok().bodyValue(configurationByUsingValue);
    }

}
