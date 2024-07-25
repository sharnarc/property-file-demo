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
public class ProjectService1Impl implements ProjectService1{


    private final WebClient.Builder webClientBuilder;

    @Override
    public Mono<ProjectDTO> findByProjectId(String projectId) {

            return webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/project/3")
                .retrieve()
                .bodyToMono(ProjectDTO.class);

    }


}
