package com.example.demo.service;

import com.example.demo.model.HealthLog;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

@Service
public class HealthLogService {

    public String evaluateRiskLevel(double sleepHours, int steps, int moodScore) {
        if (sleepHours < 6.0) {
            if (steps < 5000) {
                return moodScore <= 4 ? "高" : "中";
            }
            return moodScore <= 4 ? "中" : "低";
        }

        if (steps < 5000) {
            return moodScore <= 4 ? "中" : "低";
        }

        return moodScore <= 4 ? "中" : "低";
    }

    public HealthLog createLog(String userId, LocalDate logDate, double sleepHours, int steps, int moodScore) {
        String normalizedUserId = StringUtils.hasText(userId) ? userId.trim() : "GUEST";
        String riskLevel = evaluateRiskLevel(sleepHours, steps, moodScore);
        return new HealthLog(normalizedUserId, logDate, sleepHours, steps, moodScore, riskLevel);
    }
}
