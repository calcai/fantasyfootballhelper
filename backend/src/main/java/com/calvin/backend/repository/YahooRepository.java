package com.calvin.backend.repository;


import com.calvin.backend.models.Yahoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YahooRepository extends JpaRepository<Yahoo, Integer> {
}
