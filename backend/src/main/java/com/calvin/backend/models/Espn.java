package com.calvin.backend.models;

import jakarta.persistence.*;


@Entity
@Table(name = "players")
public class Espn {

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

    // No-argument constructor
    public Espn() {
    }

    // Parameterized constructor 
    public Espn(int playerId, String name, int standardRank, int halfPprRank, int pprRank) {
        this.playerId = playerId;
        this.name = name;
        this.standardRank = standardRank;
        this.halfPprRank = halfPprRank;
        this.pprRank = pprRank;
    }

    // Getter and Setter for playerId
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for standardRank
    public int getStandardRank() {
        return standardRank;
    }

    public void setStandardRank(int standardRank) {
        this.standardRank = standardRank;
    }

    // Getter and Setter for halfPprRank
    public int getHalfPprRank() {
        return halfPprRank;
    }

    public void setHalfPprRank(int halfPprRank) {
        this.halfPprRank = halfPprRank;
    }

    // Getter and Setter for pprRank
    public int getPprRank() {
        return pprRank;
    }

    public void setPprRank(int pprRank) {
        this.pprRank = pprRank;
    }
}