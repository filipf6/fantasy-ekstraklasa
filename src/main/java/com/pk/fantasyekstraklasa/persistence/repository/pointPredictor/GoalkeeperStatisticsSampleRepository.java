package com.pk.fantasyekstraklasa.persistence.repository.pointPredictor;

import com.pk.fantasyekstraklasa.persistence.model.pointPredictor.GoalkeeperStatisticsSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalkeeperStatisticsSampleRepository extends JpaRepository<GoalkeeperStatisticsSample, Long> {
    GoalkeeperStatisticsSample findFirstByPlayerIdAndFixtureId(Integer playerId, Integer fixtureId);
}
