package com.pk.fantasyekstraklasa.persistence.repository;

import com.pk.fantasyekstraklasa.persistence.model.Team;
import com.pk.fantasyekstraklasa.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepository extends JpaRepository<Team, Long> {
    Team findTeamByUser(User user);
}
