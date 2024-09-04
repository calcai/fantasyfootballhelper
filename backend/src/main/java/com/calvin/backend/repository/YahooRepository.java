package com.calvin.backend.repository;


import com.calvin.backend.models.Yahoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface YahooRepository extends JpaRepository<Yahoo, Integer>, JpaSpecificationExecutor<Yahoo> {
}
