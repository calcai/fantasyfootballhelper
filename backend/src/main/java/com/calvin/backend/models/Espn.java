package com.calvin.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "espn")
public class Espn extends Platform {
    public Espn() {
    }

    public Espn(int playerId, String name, int standardRank, int halfPprRank, int pprRank) {
        setPlayerId(playerId);
        setName(name);
        setStandardRank(standardRank);
        setHalfPprRank(halfPprRank);
        setPprRank(pprRank);
    }
}
