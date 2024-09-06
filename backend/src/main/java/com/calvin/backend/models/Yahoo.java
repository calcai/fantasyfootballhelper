package com.calvin.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "yahoo")
public class Yahoo extends Platform {
    public Yahoo() {
    }

    public Yahoo(int playerId, String name, int standardRank, int halfPprRank, int pprRank) {
        setPlayerId(playerId);
        setName(name);
        setStandardRank(standardRank);
        setHalfPprRank(halfPprRank);
        setPprRank(pprRank);
    }
}
