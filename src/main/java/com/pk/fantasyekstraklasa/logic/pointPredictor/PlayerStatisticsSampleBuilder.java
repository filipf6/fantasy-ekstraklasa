package com.pk.fantasyekstraklasa.logic.pointPredictor;

import com.fasterxml.jackson.databind.JsonNode;
import com.pk.fantasyekstraklasa.persistence.model.pointPredictor.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlayerStatisticsSampleBuilder {

    private static final int numberOfPreviousMatchesConsidered = 3;

    public static GoalkeeperStatisticsSample buildGoalkeeperStatisticsSample(JsonNode playerGeneralInfo, JsonNode playerSpecificInfo, JsonNode playersTeam) {
        GoalkeeperStatisticsSample goalkeeperStatisticsSample = new GoalkeeperStatisticsSample();
        buildGeneralStatistics(goalkeeperStatisticsSample, playerGeneralInfo, playerSpecificInfo, playersTeam);
        goalkeeperStatisticsSample.setPreviousFixturesCleanSheets(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "clean_sheets"));
        goalkeeperStatisticsSample.setPreviousFixturesGoalsConceded(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "goals_conceded"));
        goalkeeperStatisticsSample.setPreviousFixturesPenaltiesSaved(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "penalties_saved"));
        goalkeeperStatisticsSample.setPreviousFixturesSaves(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "saves"));

        return goalkeeperStatisticsSample;
    }

    public static DefenderStatisticsSample buildDefenderStatisticsSample(JsonNode playerGeneralInfo, JsonNode playerSpecificInfo, JsonNode playersTeam) {
        DefenderStatisticsSample defenderStatisticsSample = new DefenderStatisticsSample();
        buildGeneralStatistics(defenderStatisticsSample, playerGeneralInfo, playerSpecificInfo, playersTeam);
        defenderStatisticsSample.setPreviousFixturesGoals(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "goals_scored"));
        defenderStatisticsSample.setPreviousFixturesAssists(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "assists"));
        defenderStatisticsSample.setPreviousFixturesCleanSheets(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "clean_sheets"));
        defenderStatisticsSample.setPreviousFixturesGoalsConceded(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "goals_conceded"));
        defenderStatisticsSample.setPreviousFixturesChancesCreated(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "big_chances_created"));
        defenderStatisticsSample.setPreviousFixturesBlocks(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "clearances_blocks_interceptions"));
        defenderStatisticsSample.setPreviousFixturesRecoveries(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "recoveries"));
        defenderStatisticsSample.setPreviousFixturesKeyPasses(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "key_passes"));
        defenderStatisticsSample.setPreviousFixturesTackles(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "tackles"));
        defenderStatisticsSample.setPreviousFixturesWinningGoals(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "winning_goals"));
        defenderStatisticsSample.setPreviousFixturesFatalErrors(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "errors_leading_to_goal"));
        defenderStatisticsSample.setPreviousFixturesErrors(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "errors_leading_to_goal_attempt"));
        defenderStatisticsSample.setPreviousFixturesTackled(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "tackled"));
        defenderStatisticsSample.setPreviousFixturesFouls(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "fouls"));
        defenderStatisticsSample.setPreviousFixturesDribbles(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "dribbles"));

        return defenderStatisticsSample;
    }

    public static MidfielderStatisticsSample buildMidfielderStatisticsSample(JsonNode playerGeneralInfo, JsonNode playerSpecificInfo, JsonNode playersTeam) {
        MidfielderStatisticsSample midfielderStatisticsSample = new MidfielderStatisticsSample();
        buildGeneralStatistics(midfielderStatisticsSample, playerGeneralInfo, playerSpecificInfo, playersTeam);
        midfielderStatisticsSample.setPreviousFixturesGoals(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "goals_scored"));
        midfielderStatisticsSample.setPreviousFixturesAssists(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "assists"));
        midfielderStatisticsSample.setPreviousFixturesCleanSheets(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "clean_sheets"));
        midfielderStatisticsSample.setPreviousFixturesGoalsConceded(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "goals_conceded"));
        midfielderStatisticsSample.setPreviousFixturesChancesCreated(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "big_chances_created"));
        midfielderStatisticsSample.setPreviousFixturesBlocks(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "clearances_blocks_interceptions"));
        midfielderStatisticsSample.setPreviousFixturesRecoveries(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "recoveries"));
        midfielderStatisticsSample.setPreviousFixturesKeyPasses(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "key_passes"));
        midfielderStatisticsSample.setPreviousFixturesTackles(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "tackles"));
        midfielderStatisticsSample.setPreviousFixturesWinningGoals(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "winning_goals"));

        midfielderStatisticsSample.setPreviousFixturesChancesMissed(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "big_chances_missed"));
        midfielderStatisticsSample.setPreviousFixturesFatalErrors(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "errors_leading_to_goal"));
        midfielderStatisticsSample.setPreviousFixturesErrors(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "errors_leading_to_goal_attempt"));
        midfielderStatisticsSample.setPreviousFixturesTackled(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "tackled"));
        midfielderStatisticsSample.setPreviousFixturesFouls(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "fouls"));
        midfielderStatisticsSample.setPreviousFixturesDribbles(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "dribbles"));


        return midfielderStatisticsSample;
    }

    public static ForwardStatisticsSample buildForwardStatisticsSample(JsonNode playerGeneralInfo, JsonNode playerSpecificInfo, JsonNode playersTeam) {
        ForwardStatisticsSample forwardStatisticsSample = new ForwardStatisticsSample();
        buildGeneralStatistics(forwardStatisticsSample, playerGeneralInfo, playerSpecificInfo, playersTeam);

        forwardStatisticsSample.setPreviousFixturesGoals(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "goals_scored"));
        forwardStatisticsSample.setPreviousFixturesAssists(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "assists"));
        forwardStatisticsSample.setPreviousFixturesChancesCreated(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "big_chances_created"));
        forwardStatisticsSample.setPreviousFixturesKeyPasses(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "key_passes"));
        forwardStatisticsSample.setPreviousFixturesWinningGoals(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "winning_goals"));
        forwardStatisticsSample.setPreviousFixturesChancesMissed(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "big_chances_missed"));
        forwardStatisticsSample.setPreviousFixturesTackled(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "tackled"));
        forwardStatisticsSample.setPreviousFixturesFouls(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "fouls"));
        forwardStatisticsSample.setPreviousFixturesDribbles(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "dribbles"));

        return forwardStatisticsSample;
    }

    private static void buildGeneralStatistics(PlayerStatisticsSample playerStatisticsSample, JsonNode playerGeneralInfo, JsonNode playerSpecificInfo, JsonNode playersTeam) {
        playerStatisticsSample.setPlayerId(playerGeneralInfo.get("id").intValue());
        playerStatisticsSample.setFixtureId(playerSpecificInfo.get("fixtures_summary").get(0).get("id").intValue());
        playerStatisticsSample.setCost(playerGeneralInfo.get("now_cost").intValue());
        playerStatisticsSample.setPointsPerGame(playerGeneralInfo.get("points_per_game").asDouble());
        playerStatisticsSample.setForm(playerGeneralInfo.get("form").asDouble());
        playerStatisticsSample.setSelectedByPercent(playerGeneralInfo.get("selected_by_percent").asDouble());
        playerStatisticsSample.setInfluence(playerGeneralInfo.get("influence").asDouble());
        playerStatisticsSample.setCreativity(playerGeneralInfo.get("creativity").asDouble());
        playerStatisticsSample.setThreat(playerGeneralInfo.get("threat").asDouble());
        playerStatisticsSample.setIctIndex(playerGeneralInfo.get("ict_index").asDouble());
        playerStatisticsSample.setTeamStrength(playersTeam.get("strength").intValue());
        playerStatisticsSample.setLastSeasonPointsPerMinute(countHistoricalSeasonPointsPerMinute(1, playerSpecificInfo));
        playerStatisticsSample.setTwoSeasonsAgoPointsPerMinute(countHistoricalSeasonPointsPerMinute(2, playerSpecificInfo));
        playerStatisticsSample.setFixtureDifficulty(playerSpecificInfo.get("fixtures_summary").get(0).get("difficulty").intValue());
        playerStatisticsSample.setIsHome(playerSpecificInfo.get("fixtures_summary").get(0).get("is_home").asInt());
        playerStatisticsSample.setIsSlightlyInjured(playerGeneralInfo.get("status").textValue().equals("d") ? 1 : 0);
        playerStatisticsSample.setPreviousFixturesPoints(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "total_points"));
        playerStatisticsSample.setPreviousFixturesTransferBalance(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "transfers_balance"));
        playerStatisticsSample.setPreviousFixturesMinutes(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "minutes"));
        playerStatisticsSample.setPreviousFixturesBonus(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "bonus"));
        playerStatisticsSample.setPreviousFixturesInfluence(buildPreviousMatchesDoubleStatistics(playerSpecificInfo.get("history_summary"), "influence"));
        playerStatisticsSample.setPreviousFixturesCreativity(buildPreviousMatchesDoubleStatistics(playerSpecificInfo.get("history_summary"), "creativity"));
        playerStatisticsSample.setPreviousFixturesThreat(buildPreviousMatchesDoubleStatistics(playerSpecificInfo.get("history_summary"), "threat"));
        playerStatisticsSample.setPreviousFixturesIctIndex(buildPreviousMatchesDoubleStatistics(playerSpecificInfo.get("history_summary"), "ict_index"));
        playerStatisticsSample.setPreviousFixturesOpenPlayCrosses(buildPreviousMatchesIntegerStatistics(playerSpecificInfo.get("history_summary"), "open_play_crosses"));
    }

    private static Double countHistoricalSeasonPointsPerMinute(int numberOfSeasonsBack, JsonNode playerSpecificInfo) {
        JsonNode historicalSeasons = playerSpecificInfo.get("history_past");

        int historicalSeasonsSize = historicalSeasons.size();

        if (historicalSeasonsSize < numberOfSeasonsBack) return null;

        int minutesPlayed = historicalSeasons.get(historicalSeasonsSize - numberOfSeasonsBack).get("minutes").intValue();
        if (minutesPlayed == 0) return 0.0;

        return roundPoints(historicalSeasons.get(historicalSeasonsSize - numberOfSeasonsBack).get("total_points").intValue() / (double) minutesPlayed);
    }

    private static double roundPoints(double points) {
        return Math.round(points * 1000) / 1000.0;
    }

    private static ArrayList<Integer> buildPreviousMatchesIntegerStatistics(JsonNode previousMatchesStatistics, String statisticName) {
        ArrayList<Integer> stats = new ArrayList<>();
        int previousMatchesNumber = previousMatchesStatistics.size();
        int numberOfMatchesConsidered =
                previousMatchesNumber < numberOfPreviousMatchesConsidered ?
                        previousMatchesNumber : numberOfPreviousMatchesConsidered;

        for (int i = 0; i < numberOfMatchesConsidered; i++) {
            stats.add(previousMatchesStatistics.get(i).get(statisticName).asInt());
        }

        return stats;
    }

    private static ArrayList<Double> buildPreviousMatchesDoubleStatistics(JsonNode previousMatchesStatistics, String statisticName) {
        ArrayList<Double> stats = new ArrayList<>();
        int previousMatchesNumber = previousMatchesStatistics.size();
        int numberOfMatchesConsidered =
                previousMatchesNumber < numberOfPreviousMatchesConsidered ?
                        previousMatchesNumber : numberOfPreviousMatchesConsidered;
        for (int i = 0; i < numberOfMatchesConsidered; i++) {
            stats.add(previousMatchesStatistics.get(i).get(statisticName).asDouble());
        }
        return stats;
    }
}

