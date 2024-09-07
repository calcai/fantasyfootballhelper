package com.calvin.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int playerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "team")
    private String team;

    @Column(name = "bye")
    private int bye;

    @Column(name = "position")
    private String position;

    @OneToOne
    @JoinColumn(name = "player_id")
    private Espn espn;

    @OneToOne
    @JoinColumn(name = "player_id")
    private Sleeper sleeper;

    @OneToOne
    @JoinColumn(name = "player_id")
    private Yahoo yahoo;

    public int getPlayerId() {
        return playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getBye() {
        return bye;
    }

    public void setBye(int bye) {
        this.bye = bye;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
