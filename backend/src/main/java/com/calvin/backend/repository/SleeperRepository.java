package com.calvin.backend.repository;


import com.calvin.backend.models.Sleeper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SleeperRepository extends JpaRepository<Sleeper, Integer> {
}
