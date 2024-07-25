package com.autoconfig.property.file.demo.service;

import com.autoconfig.property.file.demo.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    private final RestTemplate restTemplate;

    @Value("${spring.api.employeeUrl}")
    private  String projectUrl ;

    @Override
    public Mono<EmployeeDTO> getEntitlements(String rollNumber) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = projectUrl + "/" + rollNumber;
        EmployeeDTO responseDTO=  restTemplate.exchange(url, HttpMethod.GET, entity, EmployeeDTO.class).getBody();
       return Mono.just(responseDTO);

    }

    public Mono<EmployeeDTO> callAnotherService() {

        EmployeeDTO response = restTemplate.getForObject("http://localhost:8082/employee/E654321", EmployeeDTO.class);
        return Mono.just(response);
    }

}
