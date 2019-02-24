package com.pk.fantasyekstraklasa.persistence.repository.pointPredictor;

import com.pk.fantasyekstraklasa.persistence.model.pointPredictor.ForwardStatisticsSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForwardStatisticsSampleRepository extends JpaRepository<ForwardStatisticsSample, Long> {
    ForwardStatisticsSample findFirstByPlayerIdAndFixtureId(Integer playerId, Integer fixtureId);
}
