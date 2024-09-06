package com.calvin.backend.models;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Platform {

    @Id
    @Column(name = "player_id")
    private int playerId;

    @Column(name = "name")
    private String name;

    @Column(name = "standard_rank")
    private int standardRank;

    @Column(name = "half_ppr_rank")
    private int halfPprRank;

    @Column(name = "ppr_rank")
    private int pprRank;

    @OneToOne
    @JoinColumn(name = "player_id")
    private Player player;

    // Getters and setters
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStandardRank() {
        return standardRank;
    }

    public void setStandardRank(int standardRank) {
        this.standardRank = standardRank;
    }

    public int getHalfPprRank() {
        return halfPprRank;
    }

    public void setHalfPprRank(int halfPprRank) {
        this.halfPprRank = halfPprRank;
    }

    public int getPprRank() {
        return pprRank;
    }

    public void setPprRank(int pprRank) {
        this.pprRank = pprRank;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
