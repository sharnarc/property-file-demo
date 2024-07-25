package com.autoconfig.property.file.demo.service;

import com.autoconfig.property.file.demo.dto.ProjectDTO;
import reactor.core.publisher.Mono;

public interface ProjectService1 {

    Mono<ProjectDTO> findByProjectId(String projectId);

}
