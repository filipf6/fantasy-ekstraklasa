package com.pk.fantasyekstraklasa.persistence.model.pointPredictor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public abstract class PlayerStatisticsSample {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // variables needed to identify specific sample when filling player's score
    private Integer playerId;
    private Integer fixtureId;

    // dependent variable
    private Integer score;

    // independent variables

    private Integer cost;
    private Double pointsPerGame;

    private Double form;
    private Double selectedByPercent;
    private Double influence;
    private Double creativity;
    private Double threat;
    private Double ictIndex;
    private Integer teamStrength;
    private Double lastSeasonPointsPerMinute;
    private Double twoSeasonsAgoPointsPerMinute;
    private Integer fixtureDifficulty;
    private Integer isHome;
    private Integer isSlightlyInjured;

    @ElementCollection
    private List<Integer> previousFixturesPoints = new ArrayList<>();
    @ElementCollection
    private List<Integer> previousFixturesTransferBalance = new ArrayList<>();
    @ElementCollection
    private List<Integer> previousFixturesMinutes = new ArrayList<>();
    @ElementCollection
    private List<Integer> previousFixturesBonus = new ArrayList<>();
    @ElementCollection
    private List<Double> previousFixturesInfluence = new ArrayList<>();
    @ElementCollection
    private List<Double> previousFixturesCreativity = new ArrayList<>();
    @ElementCollection
    private List<Double> previousFixturesThreat = new ArrayList<>();
    @ElementCollection
    private List<Double> previousFixturesIctIndex = new ArrayList<>();
    @ElementCollection
    private List<Integer> previousFixturesOpenPlayCrosses = new ArrayList<>();

//    private Integer previousFixturesPoints1;
//    private Integer previousFixturesPoints2;
//    private Integer previousFixturesPoints3;
//    private Integer previousFixturesTransferBalance1;
//    private Integer previousFixturesTransferBalance2;
//    private Integer previousFixturesTransferBalance3;
//    private Integer previousFixturesMinutes1;
//    private Integer previousFixturesMinutes2;
//    private Integer previousFixturesMinutes3;
//    private Integer previousFixturesBonus3;
//    private Integer previousFixturesBonus1;
//    private Integer previousFixturesBonus2;
//    private Double previousFixturesInfluence1;
//    private Double previousFixturesInfluence2;
//    private Double previousFixturesInfluence3;
//    private Double previousFixturesCreativity1;
//    private Double previousFixturesCreativity2;
//    private Double previousFixturesCreativity3;
//    private Double previousFixturesThreat1;
//    private Double previousFixturesThreat2;
//    private Double previousFixturesThreat3;
//    private Double previousFixturesIctIndex1;
//    private Double previousFixturesIctIndex2;
//    private Double previousFixturesIctIndex3;
//    private Integer previousFixturesOpenPlayCrosses1;
//    private Integer previousFixturesOpenPlayCrosses2;
//    private Integer previousFixturesOpenPlayCrosses3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(Integer fixtureId) {
        this.fixtureId = fixtureId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Double getPointsPerGame() {
        return pointsPerGame;
    }

    public void setPointsPerGame(Double pointsPerGame) {
        this.pointsPerGame = pointsPerGame;
    }

    public Double getForm() {
        return form;
    }

    public void setForm(Double form) {
        this.form = form;
    }

    public Double getSelectedByPercent() {
        return selectedByPercent;
    }

    public void setSelectedByPercent(Double selectedByPercent) {
        this.selectedByPercent = selectedByPercent;
    }

    public Double getInfluence() {
        return influence;
    }

    public void setInfluence(Double influence) {
        this.influence = influence;
    }

    public Double getCreativity() {
        return creativity;
    }

    public void setCreativity(Double creativity) {
        this.creativity = creativity;
    }

    public Double getThreat() {
        return threat;
    }

    public void setThreat(Double threat) {
        this.threat = threat;
    }

    public Double getIctIndex() {
        return ictIndex;
    }

    public void setIctIndex(Double ictIndex) {
        this.ictIndex = ictIndex;
    }

    public Integer getTeamStrength() {
        return teamStrength;
    }

    public void setTeamStrength(Integer teamStrength) {
        this.teamStrength = teamStrength;
    }

    public Double getLastSeasonPointsPerMinute() {
        return lastSeasonPointsPerMinute;
    }

    public void setLastSeasonPointsPerMinute(Double lastSeasonPointsPerMinute) {
        this.lastSeasonPointsPerMinute = lastSeasonPointsPerMinute;
    }

    public Double getTwoSeasonsAgoPointsPerMinute() {
        return twoSeasonsAgoPointsPerMinute;
    }

    public void setTwoSeasonsAgoPointsPerMinute(Double twoSeasonsAgoPointsPerMinute) {
        this.twoSeasonsAgoPointsPerMinute = twoSeasonsAgoPointsPerMinute;
    }

    public Integer getFixtureDifficulty() {
        return fixtureDifficulty;
    }

    public void setFixtureDifficulty(Integer fixtureDifficulty) {
        this.fixtureDifficulty = fixtureDifficulty;
    }

    public Integer getIsHome() {
        return isHome;
    }

    public void setIsHome(Integer isHome) {
        this.isHome = isHome;
    }

    public Integer getIsSlightlyInjured() {
        return isSlightlyInjured;
    }

    public void setIsSlightlyInjured(Integer isSlightlyInjured) {
        this.isSlightlyInjured = isSlightlyInjured;
    }

    public List<Integer> getPreviousFixturesPoints() {
        return previousFixturesPoints;
    }

    public void setPreviousFixturesPoints(List<Integer> previousFixturesPoints) {
        this.previousFixturesPoints = previousFixturesPoints;
    }

    public List<Integer> getPreviousFixturesTransferBalance() {
        return previousFixturesTransferBalance;
    }

    public void setPreviousFixturesTransferBalance(List<Integer> previousFixturesTransferBalance) {
        this.previousFixturesTransferBalance = previousFixturesTransferBalance;
    }

    public List<Integer> getPreviousFixturesMinutes() {
        return previousFixturesMinutes;
    }

    public void setPreviousFixturesMinutes(List<Integer> previousFixturesMinutes) {
        this.previousFixturesMinutes = previousFixturesMinutes;
    }

    public List<Integer> getPreviousFixturesBonus() {
        return previousFixturesBonus;
    }

    public void setPreviousFixturesBonus(List<Integer> previousFixturesBonus) {
        this.previousFixturesBonus = previousFixturesBonus;
    }

    public List<Double> getPreviousFixturesInfluence() {
        return previousFixturesInfluence;
    }

    public void setPreviousFixturesInfluence(List<Double> previousFixturesInfluence) {
        this.previousFixturesInfluence = previousFixturesInfluence;
    }

    public List<Double> getPreviousFixturesCreativity() {
        return previousFixturesCreativity;
    }

    public void setPreviousFixturesCreativity(List<Double> previousFixturesCreativity) {
        this.previousFixturesCreativity = previousFixturesCreativity;
    }

    public List<Double> getPreviousFixturesThreat() {
        return previousFixturesThreat;
    }

    public void setPreviousFixturesThreat(List<Double> previousFixturesThreat) {
        this.previousFixturesThreat = previousFixturesThreat;
    }

    public List<Double> getPreviousFixturesIctIndex() {
        return previousFixturesIctIndex;
    }

    public void setPreviousFixturesIctIndex(List<Double> previousFixturesIctIndex) {
        this.previousFixturesIctIndex = previousFixturesIctIndex;
    }

    public List<Integer> getPreviousFixturesOpenPlayCrosses() {
        return previousFixturesOpenPlayCrosses;
    }

    public void setPreviousFixturesOpenPlayCrosses(List<Integer> previousFixturesOpenPlayCrosses) {
        this.previousFixturesOpenPlayCrosses = previousFixturesOpenPlayCrosses;
    }

    @Override
    public String toString() {
        return "PlayerStatisticsSample{" +
                "id=" + id +
                ", playerId=" + playerId +
                ", fixtureId=" + fixtureId +
                ", score=" + score +
                ", cost=" + cost +
                ", pointsPerGame=" + pointsPerGame +
                ", form=" + form +
                ", selectedByPercent=" + selectedByPercent +
                ", influence=" + influence +
                ", creativity=" + creativity +
                ", threat=" + threat +
                ", ictIndex=" + ictIndex +
                ", teamStrength=" + teamStrength +
                ", lastSeasonPointsPerMinute=" + lastSeasonPointsPerMinute +
                ", twoSeasonsAgoPointsPerMinute=" + twoSeasonsAgoPointsPerMinute +
                ", fixtureDifficulty=" + fixtureDifficulty +
                ", isHome=" + isHome +
                ", isSlightlyInjured=" + isSlightlyInjured +
                ", previousFixturesPoints=" + previousFixturesPoints +
                ", previousFixturesTransferBalance=" + previousFixturesTransferBalance +
                ", previousFixturesMinutes=" + previousFixturesMinutes +
                ", previousFixturesBonus=" + previousFixturesBonus +
                ", previousFixturesInfluence=" + previousFixturesInfluence +
                ", previousFixturesCreativity=" + previousFixturesCreativity +
                ", previousFixturesThreat=" + previousFixturesThreat +
                ", previousFixturesIctIndex=" + previousFixturesIctIndex +
                ", previousFixturesOpenPlayCrosses=" + previousFixturesOpenPlayCrosses +
                '}';
    }
}
