package com.autoconfig.property.file.demo.service;

import com.autoconfig.property.file.demo.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService{

    @Value("${spring.api.projectUrl}")
    private String projectUrl;

    private final WebClient projectsAvailableWebClient;

    @Override
    public Mono<ProjectDTO> findByProjectIdWebClient(String projectId) {

        return projectsAvailableWebClient
            .get()
            .uri(projectUrl + "/" + projectId)
            .retrieve()
            .bodyToMono(ProjectDTO.class);

    }

}
