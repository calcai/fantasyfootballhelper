package com.calvin.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "sleeper")
public class Sleeper extends Platform {
    public Sleeper() {
    }

    public Sleeper(int playerId, String name, int standardRank, int halfPprRank, int pprRank) {
        setPlayerId(playerId);
        setName(name);
        setStandardRank(standardRank);
        setHalfPprRank(halfPprRank);
        setPprRank(pprRank);
    }
}
