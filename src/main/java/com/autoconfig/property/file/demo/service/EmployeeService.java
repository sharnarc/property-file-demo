package com.autoconfig.property.file.demo.service;

import com.autoconfig.property.file.demo.dto.EmployeeDTO;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Mono<EmployeeDTO> getEntitlements(String id);

}
