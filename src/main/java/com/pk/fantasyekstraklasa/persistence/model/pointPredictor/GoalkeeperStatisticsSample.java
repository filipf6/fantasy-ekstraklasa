package com.pk.fantasyekstraklasa.persistence.model.pointPredictor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goalkeeper_statistics_sample")
public class GoalkeeperStatisticsSample extends PlayerStatisticsSample {
    @ElementCollection
    private List<Integer> previousFixturesCleanSheets = new ArrayList<>();
    @ElementCollection
    private List<Integer> previousFixturesGoalsConceded = new ArrayList<>();
    @ElementCollection
    private List<Integer> previousFixturesPenaltiesSaved = new ArrayList<>();
    @ElementCollection
    private List<Integer> previousFixturesSaves = new ArrayList<>();

    public List<Integer> getPreviousFixturesCleanSheets() {
        return previousFixturesCleanSheets;
    }

    public void setPreviousFixturesCleanSheets(List<Integer> previousFixturesCleanSheets) {
        this.previousFixturesCleanSheets = previousFixturesCleanSheets;
    }

    public List<Integer> getPreviousFixturesGoalsConceded() {
        return previousFixturesGoalsConceded;
    }

    public void setPreviousFixturesGoalsConceded(List<Integer> previousFixturesGoalsConceded) {
        this.previousFixturesGoalsConceded = previousFixturesGoalsConceded;
    }

    public List<Integer> getPreviousFixturesPenaltiesSaved() {
        return previousFixturesPenaltiesSaved;
    }

    public void setPreviousFixturesPenaltiesSaved(List<Integer> previousFixturesPenaltiesSaved) {
        this.previousFixturesPenaltiesSaved = previousFixturesPenaltiesSaved;
    }

    public List<Integer> getPreviousFixturesSaves() {
        return previousFixturesSaves;
    }

    public void setPreviousFixturesSaves(List<Integer> previousFixturesSaves) {
        this.previousFixturesSaves = previousFixturesSaves;
    }

    @Override
    public String toString() {
        return "GoalkeeperStatisticsSample{" +
                "previousFixturesCleanSheets=" + previousFixturesCleanSheets +
                ", previousFixturesGoalsConceded=" + previousFixturesGoalsConceded +
                ", previousFixturesPenaltiesSaved=" + previousFixturesPenaltiesSaved +
                ", previousFixturesSaves=" + previousFixturesSaves +
                '}';
    }
}
