package com.pk.fantasyekstraklasa.persistence.repository;

import com.pk.fantasyekstraklasa.persistence.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersRepository extends JpaRepository<Player, Long> {
}
