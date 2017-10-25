package com.pk.fantasyekstraklasa.persistence.repository;

import com.pk.fantasyekstraklasa.persistence.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaguesRepository extends JpaRepository<League, Long> {
}
