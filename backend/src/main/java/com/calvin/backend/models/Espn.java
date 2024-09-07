package com.calvin.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "espn")
public class Espn extends Platform {
    public Espn() {
    }

    public Espn(Integer playerId, String name, Integer standardRank, Integer halfPprRank, Integer pprRank) {
        setPlayerId(playerId);
        setName(name);
        setStandardRank(standardRank);
        setHalfPprRank(halfPprRank);
        setPprRank(pprRank);
    }
}
