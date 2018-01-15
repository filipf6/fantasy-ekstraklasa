package com.pk.fantasyekstraklasa.persistence.repository;

import com.pk.fantasyekstraklasa.persistence.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayersRepository extends JpaRepository<Player, Long> {
    List<Player> findByNameIgnoreCaseContainingOrSurnameIgnoreCaseContaining(String searchValue1, String searchValue2); //OrSurnameIgnoreCaseOrderByPriceDesc(String searchValue1, String searchValue2);
}
