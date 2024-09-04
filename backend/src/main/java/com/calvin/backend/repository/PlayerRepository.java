package com.calvin.backend.repository;


import com.calvin.backend.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlayerRepository extends JpaRepository<Player, Integer>, JpaSpecificationExecutor<Player> {
}
