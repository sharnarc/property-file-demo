package com.autoconfig.property.file.demo.handler;

import com.autoconfig.property.file.demo.config.CurrencyServiceConfiguration;
import com.autoconfig.property.file.demo.config.CurrencyServiceConfigurationByUsingValue;
import com.autoconfig.property.file.demo.config.UserSearchPublicConfig;
import com.autoconfig.property.file.demo.dto.EmployeeDTO;
import com.autoconfig.property.file.demo.dto.ProjectDTO;
import com.autoconfig.property.file.demo.service.EmployeeService;
import com.autoconfig.property.file.demo.service.ProjectService;
import com.autoconfig.property.file.demo.service.ProjectService1;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
@AllArgsConstructor

public class CurrencyServiceConfigurationHandler {


    private final CurrencyServiceConfiguration currencyServiceConfiguration;
    private final UserSearchPublicConfig userSearchPublicConfig;
    private final CurrencyServiceConfigurationByUsingValue configurationByUsingValue;
    private final EmployeeService employeeService;
    private final ProjectService projectService;
    private final ProjectService1 projectService1;

    public Mono<ServerResponse> getConfigDetails(ServerRequest serverRequest) {

        return ServerResponse.ok().bodyValue(currencyServiceConfiguration);
    }

    public Mono<ServerResponse> getConfigDetailsForUsers(ServerRequest serverRequest) {

        return ServerResponse.ok().bodyValue(userSearchPublicConfig);
    }

    public Mono<ServerResponse> getConfigDetailsForUsersByValues(ServerRequest serverRequest) {

        return ServerResponse.ok().bodyValue(configurationByUsingValue);
    }

    public Mono<ServerResponse> getUserDetailsFromReactiveService(ServerRequest serverRequest) {

        var rollNumber = serverRequest.pathVariable("number");
/*        final List<String> authHeader = serverRequest.headers().header(HttpHeaders.AUTHORIZATION);
        if (authHeader.isEmpty()) {
            return Mono.error(new RuntimeException("AUTHORIZATION_FAILED_MESSAGE"));
        }
        final String token = authHeader.get(0);*/


        return ServerResponse.ok().body(employeeService.getEntitlements(rollNumber), EmployeeDTO.class);
  /*      return employeeService.getEntitlements(rollNumber)
            .flatMap(response -> ServerResponse.ok().bodyValue(response));*/
    }


    public Mono<ServerResponse> getProjectDetails(ServerRequest serverRequest) {

        var projectId = serverRequest.pathVariable("projectId");
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(projectService1.findByProjectId(projectId), ProjectDTO.class);
    }

    public Mono<ServerResponse> getProjectDetailsViaClient(ServerRequest serverRequest) {

        var projectId = serverRequest.pathVariable("projectId");
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(projectService.findByProjectIdWebClient(projectId), ProjectDTO.class);
    }

}
