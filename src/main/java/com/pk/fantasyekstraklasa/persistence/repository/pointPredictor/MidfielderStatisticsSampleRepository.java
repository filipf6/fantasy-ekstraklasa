package com.pk.fantasyekstraklasa.persistence.repository.pointPredictor;

import com.pk.fantasyekstraklasa.persistence.model.pointPredictor.MidfielderStatisticsSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MidfielderStatisticsSampleRepository extends JpaRepository<MidfielderStatisticsSample, Long> {
    MidfielderStatisticsSample findFirstByPlayerIdAndFixtureId(Integer playerId, Integer fixtureId);
}
