package com.calvin.backend.models;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Platform {

    @Id
    @Column(name = "player_id")
    private Integer playerId;

    @Column(name = "name")
    private String name;

    @Column(name = "standard_rank")
    private Integer standardRank;

    @Column(name = "half_ppr_rank")
    private Integer halfPprRank;

    @Column(name = "ppr_rank")
    private Integer pprRank;

    @OneToOne
    @JoinColumn(name = "player_id")
    private Player player;

    // Getters and setters
    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStandardRank() {
        return standardRank;
    }

    public void setStandardRank(Integer standardRank) {
        this.standardRank = standardRank;
    }

    public Integer getHalfPprRank() {
        return halfPprRank;
    }

    public void setHalfPprRank(Integer halfPprRank) {
        this.halfPprRank = halfPprRank;
    }

    public Integer getPprRank() {
        return pprRank;
    }

    public void setPprRank(Integer pprRank) {
        this.pprRank = pprRank;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
