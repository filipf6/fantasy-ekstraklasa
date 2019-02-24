package com.pk.fantasyekstraklasa.logic.pointPredictor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pk.fantasyekstraklasa.persistence.model.pointPredictor.DefenderStatisticsSample;
import com.pk.fantasyekstraklasa.persistence.model.pointPredictor.ForwardStatisticsSample;
import com.pk.fantasyekstraklasa.persistence.model.pointPredictor.GoalkeeperStatisticsSample;
import com.pk.fantasyekstraklasa.persistence.model.pointPredictor.MidfielderStatisticsSample;
import com.pk.fantasyekstraklasa.persistence.repository.pointPredictor.DefenderStatisticsSampleRepository;
import com.pk.fantasyekstraklasa.persistence.repository.pointPredictor.ForwardStatisticsSampleRepository;
import com.pk.fantasyekstraklasa.persistence.repository.pointPredictor.GoalkeeperStatisticsSampleRepository;
import com.pk.fantasyekstraklasa.persistence.repository.pointPredictor.MidfielderStatisticsSampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class DataGathererService {

    private GoalkeeperStatisticsSampleRepository goalkeeperStatisticsSampleRepository;
    private DefenderStatisticsSampleRepository defenderStatisticsSampleRepository;
    private MidfielderStatisticsSampleRepository midfielderStatisticsSampleRepository;
    private ForwardStatisticsSampleRepository forwardStatisticsSampleRepository;

    private final int GOALKEEPER_STATISTICS_SAMPLE_NUMBER = 1;
    private final int DEFENDER_STATISTICS_SAMPLE_NUMBER = 2;
    private final int MIDFIELDER_STATISTICS_SAMPLE_NUMBER = 3;
    private final int FORWARD_STATISTICS_SAMPLE_NUMBER = 4;

    private final String allInformationResourceUrl = "https://fantasy.premierleague.com/drf/bootstrap-static";
    private final String playersResourceUrl = "https://fantasy.premierleague.com/drf/element-summary/";

    @Autowired
    public DataGathererService(
            GoalkeeperStatisticsSampleRepository goalkeeperStatisticsSampleRepository,
            DefenderStatisticsSampleRepository defenderStatisticsSamplesRepository,
            MidfielderStatisticsSampleRepository midfielderStatisticsSampleRepository,
            ForwardStatisticsSampleRepository forwardStatisticsSampleRepository) {
        this.goalkeeperStatisticsSampleRepository = goalkeeperStatisticsSampleRepository;
        this.defenderStatisticsSampleRepository = defenderStatisticsSamplesRepository;
        this.midfielderStatisticsSampleRepository = midfielderStatisticsSampleRepository;
        this.forwardStatisticsSampleRepository = forwardStatisticsSampleRepository;
    }

    public void gatherStatistics() {
        RestTemplate restTemplate = new RestTemplate();
        String teamsResourceUrl = "https://fantasy.premierleague.com/drf/teams";

        ResponseEntity<String> allInformationResponse = restTemplate.getForEntity(allInformationResourceUrl, String.class);
        ResponseEntity<String> teamsResponse = restTemplate.getForEntity(teamsResourceUrl, String.class);

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode playersRoot = mapper.readTree(allInformationResponse.getBody());
            JsonNode teamsRoot = mapper.readTree(teamsResponse.getBody());

            JsonNode playersArray = playersRoot.get("elements");

            for (JsonNode player : playersArray) {
                JsonNode playerSpecificInfo = mapper
                        .readTree(restTemplate
                                .getForEntity(playersResourceUrl + player.get("id").asText(), String.class)
                                .getBody());

                if ((!player.get("status").textValue().equals("d")
                        && !player.get("status").textValue().equals("a"))
                        || playerSpecificInfo.get("fixtures_summary").get(0).get("event").intValue()
                        != playersRoot.get("next-event").intValue()) {
                    continue;
                }

                for (JsonNode team : teamsRoot) {
                    if (team.get("id").intValue() == player.get("team").intValue()) {
                        switch (player.get("element_type").intValue()) {
                            case GOALKEEPER_STATISTICS_SAMPLE_NUMBER:
                                this.goalkeeperStatisticsSampleRepository
                                        .save(PlayerStatisticsSampleBuilder
                                                .buildGoalkeeperStatisticsSample(player, playerSpecificInfo, team));
                                break;
                            case DEFENDER_STATISTICS_SAMPLE_NUMBER:
                                this.defenderStatisticsSampleRepository
                                        .save(PlayerStatisticsSampleBuilder
                                                .buildDefenderStatisticsSample(player, playerSpecificInfo, team));
                                break;
                            case MIDFIELDER_STATISTICS_SAMPLE_NUMBER:
                                this.midfielderStatisticsSampleRepository
                                        .save(PlayerStatisticsSampleBuilder
                                                .buildMidfielderStatisticsSample(player, playerSpecificInfo, team));
                                break;
                            case FORWARD_STATISTICS_SAMPLE_NUMBER:
                                this.forwardStatisticsSampleRepository
                                        .save(PlayerStatisticsSampleBuilder
                                                .buildForwardStatisticsSample(player, playerSpecificInfo, team));
                                break;
                        }
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gatherScores() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> allInformationResponse = restTemplate.getForEntity(allInformationResourceUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode playersRoot = mapper.readTree(allInformationResponse.getBody());
            JsonNode playersArray = playersRoot.get("elements");

            int playerId, fixtureId, playerHistorySize;
            JsonNode playerHistory;

            for (JsonNode player : playersArray) {
                JsonNode playerSpecificInfo = mapper
                        .readTree(restTemplate
                                .getForEntity(playersResourceUrl + player.get("id").asText(), String.class)
                                .getBody());

                playerHistory = playerSpecificInfo.get("history");
                playerHistorySize = playerHistory.size();

                if (playerHistorySize == 0
                        || playerHistory.get(playerHistorySize - 1).get("round").intValue() + 1
                        != playersRoot.get("next-event").intValue()) {
                    continue;
                }

                playerId = player.get("id").intValue();
                fixtureId = playerHistory.get(playerHistorySize - 1).get("fixture").intValue();

                switch (player.get("element_type").intValue()) {
                    case GOALKEEPER_STATISTICS_SAMPLE_NUMBER:
                        GoalkeeperStatisticsSample goalkeeper =
                                this.goalkeeperStatisticsSampleRepository.findFirstByPlayerIdAndFixtureId(playerId, fixtureId);
                        goalkeeper.setScore(player.get("event_points").intValue());
                        this.goalkeeperStatisticsSampleRepository.save(goalkeeper);
                        break;
                    case DEFENDER_STATISTICS_SAMPLE_NUMBER:
                        DefenderStatisticsSample defender =
                                this.defenderStatisticsSampleRepository.findFirstByPlayerIdAndFixtureId(playerId, fixtureId);
                        defender.setScore(player.get("event_points").intValue());
                        this.defenderStatisticsSampleRepository.save(defender);
                        break;
                    case MIDFIELDER_STATISTICS_SAMPLE_NUMBER:
                        MidfielderStatisticsSample midfielder =
                                this.midfielderStatisticsSampleRepository.findFirstByPlayerIdAndFixtureId(playerId, fixtureId);
                        midfielder.setScore(player.get("event_points").intValue());
                        this.midfielderStatisticsSampleRepository.save(midfielder);
                        break;
                    case FORWARD_STATISTICS_SAMPLE_NUMBER:
                        ForwardStatisticsSample forward =
                                this.forwardStatisticsSampleRepository.findFirstByPlayerIdAndFixtureId(playerId, fixtureId);
                        forward.setScore(player.get("event_points").intValue());
                        this.forwardStatisticsSampleRepository.save(forward);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

