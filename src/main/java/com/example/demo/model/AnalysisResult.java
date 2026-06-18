package com.example.demo.model;

public class AnalysisResult {

    private String result;
    private double confidence;

    public AnalysisResult() {
    }

    public AnalysisResult(String result, double confidence) {
        this.result = result;
        this.confidence = confidence;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
