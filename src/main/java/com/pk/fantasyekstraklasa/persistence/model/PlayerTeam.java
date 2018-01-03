package com.pk.fantasyekstraklasa.persistence.model;


import com.pk.fantasyekstraklasa.persistence.model.enums.AccuratePosition;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "player_team")
public class PlayerTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @OneToOne
//    private Player player;

//    @OneToOne
//    private Team team;

    @ManyToOne
    @JoinColumn(name = "players_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "teams_id")
    private Team team;

    @Column(columnDefinition = "TINYINT(1)")
    @NotNull
    private boolean firstSquad;

    @Column(columnDefinition = "TINYINT(1)")
    @NotNull
    private boolean captain;

    @Column(columnDefinition = "TINYINT(1)")
    @NotNull
    private boolean viceCaptain;

    @Enumerated(EnumType.STRING)
    private AccuratePosition accuratePosition;

    public PlayerTeam() {
    }

    public PlayerTeam(Player player, Team team, boolean firstSquad, boolean captain, boolean viceCaptain, AccuratePosition accuratePosition) {
        this.player = player;
        this.team = team;
        this.firstSquad = firstSquad;
        this.captain = captain;
        this.viceCaptain = viceCaptain;
        this.accuratePosition = accuratePosition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean isFirstSquad() {
        return firstSquad;
    }

    public void setFirstSquad(boolean firstSquad) {
        this.firstSquad = firstSquad;
    }

    public boolean isCaptain() {
        return captain;
    }

    public void setCaptain(boolean captain) {
        this.captain = captain;
    }

    public boolean isViceCaptain() {
        return viceCaptain;
    }

    public void setViceCaptain(boolean viceCaptain) {
        this.viceCaptain = viceCaptain;
    }

    public AccuratePosition getAccuratePosition() {
        return accuratePosition;
    }

    public void setAccuratePosition(AccuratePosition position) {
        this.accuratePosition = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerTeam)) return false;

        PlayerTeam that = (PlayerTeam) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
