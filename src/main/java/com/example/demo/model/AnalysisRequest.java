package com.example.demo.model;

public class AnalysisRequest {

    private String name;
    private double value;
    private String category;

    public AnalysisRequest() {
    }

    public AnalysisRequest(String name, double value, String category) {
        this.name = name;
        this.value = value;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
