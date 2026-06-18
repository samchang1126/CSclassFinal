package com.example.demo.repository;

import com.example.demo.model.AnalysisRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalysisRepository extends JpaRepository<AnalysisRecord, Long> {
}
