package com.pk.fantasyekstraklasa.persistence.repository;

import com.pk.fantasyekstraklasa.persistence.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubsRepository extends JpaRepository<Club, Long> {
}
