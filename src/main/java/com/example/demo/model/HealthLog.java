package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "health_logs")
public class HealthLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("user_id")
    @Column(name = "user_id", nullable = false, length = 50)
    private String userId;

    @JsonProperty("log_date")
    @Column(name = "log_date")
    private LocalDate logDate;

    @JsonProperty("sleep_hours")
    @Column(name = "sleep_hours")
    private double sleepHours;

    private int steps;

    @JsonProperty("mood_score")
    @Column(name = "mood_score")
    private int moodScore;

    @JsonProperty("risk_level")
    @Column(name = "risk_level", length = 10)
    private String riskLevel;

    public HealthLog() {
    }

    public HealthLog(String userId, LocalDate logDate, double sleepHours, int steps, int moodScore, String riskLevel) {
        this.userId = userId;
        this.logDate = logDate;
        this.sleepHours = sleepHours;
        this.steps = steps;
        this.moodScore = moodScore;
        this.riskLevel = riskLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public double getSleepHours() {
        return sleepHours;
    }

    public void setSleepHours(double sleepHours) {
        this.sleepHours = sleepHours;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getMoodScore() {
        return moodScore;
    }

    public void setMoodScore(int moodScore) {
        this.moodScore = moodScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}
