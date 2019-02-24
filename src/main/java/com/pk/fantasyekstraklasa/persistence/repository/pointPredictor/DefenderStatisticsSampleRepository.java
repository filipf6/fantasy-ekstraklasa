package com.pk.fantasyekstraklasa.persistence.repository.pointPredictor;

import com.pk.fantasyekstraklasa.persistence.model.pointPredictor.DefenderStatisticsSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefenderStatisticsSampleRepository extends JpaRepository<DefenderStatisticsSample, Long> {
    DefenderStatisticsSample findFirstByPlayerIdAndFixtureId(Integer playerId, Integer fixtureId);
}
