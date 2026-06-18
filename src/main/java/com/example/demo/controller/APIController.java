package com.example.demo.controller;

import com.example.demo.model.AnalysisRecord;
import com.example.demo.model.AnalysisRequest;
import com.example.demo.model.AnalysisResult;
import com.example.demo.repository.AnalysisRepository;
import com.example.demo.service.MLService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    private final MLService mlService;
    private final AnalysisRepository analysisRepository;

    public APIController(MLService mlService, AnalysisRepository analysisRepository) {
        this.mlService = mlService;
        this.analysisRepository = analysisRepository;
    }

    @PostMapping(value = "/analyze", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AnalysisResult analyze(@RequestBody AnalysisRequest request) {
        AnalysisResult prediction = mlService.predictOutcome(request);

        AnalysisRecord record = new AnalysisRecord(
                request.getName(),
                request.getValue(),
                request.getCategory(),
                prediction.getResult(),
                prediction.getConfidence()
        );
        analysisRepository.save(record);

        return prediction;
    }

    @GetMapping(value = "/history", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnalysisRecord> history() {
        return analysisRepository.findAll();
    }
}
