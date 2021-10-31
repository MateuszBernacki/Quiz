package com.quiztest.Quiz;


import com.quiztest.Quiz.dto.HealthCheckDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckRestController {
    @GetMapping
    public HealthCheckDto healthCheckDto(){
        HealthCheckDto dto = new HealthCheckDto(true, "It is alive!!!");
        return dto;
    }


}
