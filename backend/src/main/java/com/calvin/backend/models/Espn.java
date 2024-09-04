package com.calvin.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "espn")
public class Espn extends Platform {

    @Id
    @PrimaryKeyJoinColumn(name = "player_id")
    private int playerId;

    @Column(name = "name")
    private String name;

    @Column(name = "standard_rank")
    private int standardRank;

    @Column(name = "half_ppr_rank")
    private int halfPprRank;

    @Column(name = "ppr_rank")
    private int pprRank;

    public Espn() {
    }

    public Espn(int playerId, String name, int standardRank, int halfPprRank, int pprRank) {
        this.playerId = playerId;
        this.name = name;
        this.standardRank = standardRank;
        this.halfPprRank = halfPprRank;
        this.pprRank = pprRank;
    }
}