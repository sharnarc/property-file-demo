package com.autoconfig.property.file.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties(prefix = "reactive-service")
@Component
public class ReactiveCrudDemoServiceConfig {
    private String url;
}
