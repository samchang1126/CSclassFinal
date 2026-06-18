package com.example.demo.controller;

import com.example.demo.model.HealthLog;
import com.example.demo.repository.HealthLogRepository;
import com.example.demo.service.HealthLogService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthLogController {

    private final HealthLogRepository healthLogRepository;
    private final HealthLogService healthLogService;

    public HealthLogController(HealthLogRepository healthLogRepository, HealthLogService healthLogService) {
        this.healthLogRepository = healthLogRepository;
        this.healthLogService = healthLogService;
    }

    @GetMapping(value = "/health-logs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HealthLog> getHealthLogs() {
        return healthLogRepository.findAll();
    }

    @PostMapping(value = "/health-logs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public HealthLog createHealthLog(@RequestBody HealthLog request) {
        HealthLog log = healthLogService.createLog(
                request.getUserId(),
                request.getLogDate(),
                request.getSleepHours(),
                request.getSteps(),
                request.getMoodScore()
        );
        return healthLogRepository.save(log);
    }
}
