package com.pk.fantasyekstraklasa.persistence.model;

import com.pk.fantasyekstraklasa.persistence.model.enums.Position;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Position position;

    @Range(min=4,max=15)
    @NotNull
    private Double price;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean injury;

    @ManyToOne
    @JoinColumn(name = "clubs_id")
    private Club club;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<Transfer> transfers = new HashSet<>(0);

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<PlayerTeam> playerTeams = new HashSet<>(0);

    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isInjury() {
        return injury;
    }

    public void setInjury(boolean injury) {
        this.injury = injury;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Set<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(Set<Transfer> transfers) {
        this.transfers = transfers;
    }

    public Set<PlayerTeam> getPlayerTeams() {
        return playerTeams;
    }

    public void setPlayerTeams(Set<PlayerTeam> playerTeams) {
        this.playerTeams = playerTeams;
    }
    //    public Set<Team> getTeams() {
//        return teams;
//    }
//
//    public void setTeams(Set<Team> teams) {
//        this.teams = teams;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        return id.equals(player.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
