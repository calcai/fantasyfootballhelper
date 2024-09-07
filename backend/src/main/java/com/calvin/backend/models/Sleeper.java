package com.calvin.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "sleeper")
public class Sleeper extends Platform {
    public Sleeper() {
    }

    public Sleeper(Integer playerId, String name, Integer standardRank, Integer halfPprRank, Integer pprRank) {
        setPlayerId(playerId);
        setName(name);
        setStandardRank(standardRank);
        setHalfPprRank(halfPprRank);
        setPprRank(pprRank);
    }
}
