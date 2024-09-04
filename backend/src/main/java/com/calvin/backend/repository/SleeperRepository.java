package com.calvin.backend.repository;


import com.calvin.backend.models.Sleeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SleeperRepository extends JpaRepository<Sleeper, Integer>, JpaSpecificationExecutor<Sleeper> {
}
