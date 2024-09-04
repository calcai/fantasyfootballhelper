package com.calvin.backend.repository;


import com.calvin.backend.models.Espn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EspnRepository extends JpaRepository<Espn, Integer>, JpaSpecificationExecutor<Espn> {
}
