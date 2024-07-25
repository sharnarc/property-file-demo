package com.autoconfig.property.file.demo.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Getter
public class CurrencyServiceConfigurationByUsingValue {
    @Value("${spring.application.service.url}")
    private String url;
    @Value("${spring.application.service.user}")
    private String username;
    @Value("${spring.application.service.key}")
    private String key;

}
