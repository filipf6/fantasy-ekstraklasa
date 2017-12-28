package com.pk.fantasyekstraklasa.persistence.repository;

import com.pk.fantasyekstraklasa.persistence.model.Player;
import com.pk.fantasyekstraklasa.persistence.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayersRepository extends JpaRepository<Player, Long> {
    List<Player> findPlayersByTeams(Team team);
}
