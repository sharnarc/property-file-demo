package com.autoconfig.property.file.demo.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.application.usersearch")
@Component
public class UserSearchPublicConfig {
    private Map<String, List<String>> allowedCountryInvoiceType = new HashMap<>();
    private Map<String, List<Character>> allowedCountryUser = new HashMap<>();
    private Map<String, List<String>> allowedBusinessArea = new HashMap<>();
}
