package com.pk.fantasyekstraklasa.persistence.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teams")
@EntityListeners(AuditingEntityListener.class)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TEAM_ID")
    private Long id;

    @NotBlank
    private String name;

    @OneToOne(mappedBy = "team")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "teams")
    private Set<Player> players = new HashSet<>(0);

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "team_league", joinColumns = @JoinColumn(name = "teams_id", referencedColumnName = "TEAM_ID"), inverseJoinColumns = @JoinColumn(name = "leagues_id", referencedColumnName = "id"))
    private Set<League> leagues = new HashSet<>(0);

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Set<Transfer> transfers = new HashSet<>(0);

    private Long captainId;

    private Long viceCaptainId;

    public Team() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Set<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(Set<League> leagues) {
        this.leagues = leagues;
    }

    public Set<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(Set<Transfer> transfers) {
        this.transfers = transfers;
    }

    public Long getCaptainId() {
        return captainId;
    }

    public void setCaptainId(Long captainId) {
        this.captainId = captainId;
    }

    public Long getViceCaptainId() {
        return viceCaptainId;
    }

    public void setViceCaptainId(Long viceCaptainId) {
        this.viceCaptainId = viceCaptainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team)) return false;

        Team team = (Team) o;

        return id != null ? id.equals(team.id) : team.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
