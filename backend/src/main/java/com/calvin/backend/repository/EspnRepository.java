package com.calvin.backend.repository;


import com.calvin.backend.models.Espn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspnRepository extends JpaRepository<Espn, Integer> {
}
