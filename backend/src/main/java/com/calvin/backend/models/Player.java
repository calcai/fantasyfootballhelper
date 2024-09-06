package com.calvin.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int playerId;

    @Column(name = "name")
    private String name;

    @Column(name = "team")
    private String team;

    @Column(name = "bye")
    private int bye;

    @OneToOne
    private Espn espn;

    @OneToOne
    private Sleeper sleeper;

    @OneToOne
    private Yahoo yahoo;

    // Getter and Setter for playerId
    public int getPlayerId() {
        return playerId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for team
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    // Getter and Setter for bye
    public int getBye() {
        return bye;
    }

    public void setBye(int bye) {
        this.bye = bye;
    }
}
