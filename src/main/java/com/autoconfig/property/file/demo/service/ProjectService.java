package com.autoconfig.property.file.demo.service;

import com.autoconfig.property.file.demo.dto.ProjectDTO;
import reactor.core.publisher.Mono;

public interface ProjectService {

    Mono<ProjectDTO> findByProjectIdWebClient(String projectId);

}
