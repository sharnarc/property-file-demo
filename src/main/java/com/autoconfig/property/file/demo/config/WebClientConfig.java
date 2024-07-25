package com.autoconfig.property.file.demo.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    private final WebClient.Builder builder;
    @Value("${spring.api.projectHost}")
    private String projectHost;

    @Bean
    WebClient projectsAvailableWebClient() {
        return buildWebClient( builder, projectHost);
    }

    private WebClient buildWebClient(WebClient.Builder builder, String host) {

            return builder
                .baseUrl(host)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, APPLICATION_JSON_VALUE)
                .build();

    }
}
