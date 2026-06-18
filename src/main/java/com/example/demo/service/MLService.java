package com.example.demo.service;

import com.example.demo.model.AnalysisRequest;
import com.example.demo.model.AnalysisResult;
import org.springframework.stereotype.Service;

@Service
public class MLService {

    public AnalysisResult predictOutcome(AnalysisRequest request) {
        String name = request.getName() != null ? request.getName().trim() : "";
        double value = request.getValue();
        String category = request.getCategory() != null ? request.getCategory().trim().toLowerCase() : "";

        double score = value * categoryWeight(category) + name.length() * 0.5;

        String result;
        double confidence;

        if (score >= 90) {
            result = "high_potential";
            confidence = 0.92;
        } else if (score >= 60) {
            result = "moderate";
            confidence = 0.78;
        } else if (score >= 30) {
            result = "needs_review";
            confidence = 0.65;
        } else {
            result = "low_potential";
            confidence = 0.55;
        }

        return new AnalysisResult(result, confidence);
    }

    private double categoryWeight(String category) {
        return switch (category) {
            case "premium", "a" -> 1.2;
            case "standard", "b" -> 1.0;
            case "basic", "c" -> 0.8;
            default -> 0.9;
        };
    }
}
