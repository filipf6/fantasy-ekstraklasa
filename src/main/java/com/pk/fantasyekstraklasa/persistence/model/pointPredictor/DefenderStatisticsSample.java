package com.pk.fantasyekstraklasa.persistence.model.pointPredictor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "defender_statistics_sample")
public class DefenderStatisticsSample extends PlayerStatisticsSample {
    @ElementCollection
    private List<Integer> previousFixturesGoals = new ArrayList<>();

//    private Integer previousFixturesGoals1;
//    private Integer previousFixturesGoals2;
//    private Integer previousFixturesGoals3;
    @ElementCollection
    private List<Integer> previousFixturesAssists = new ArrayList<>();

//    private Integer previousFixturesAssists1;
//    private Integer previousFixturesAssists2;
//    private Integer previousFixturesAssists3;
    @ElementCollection
    private List<Integer> previousFixturesCleanSheets = new ArrayList<>();

//    private Integer previousFixturesCleanSheets1;
//    private Integer previousFixturesCleanSheets2;
//    private Integer previousFixturesCleanSheets3;
    @ElementCollection
    private List<Integer> previousFixturesGoalsConceded = new ArrayList<>();

//    private Integer previousFixturesGoalsConceded1;
//    private Integer previousFixturesGoalsConceded2;
//    private Integer previousFixturesGoalsConceded3;
    @ElementCollection
    private List<Integer> previousFixturesChancesCreated = new ArrayList<>();

//    private Integer previousFixturesBigChancesCreated1;
//    private Integer previousFixturesBigChancesCreated2;
//    private Integer previousFixturesBigChancesCreated3;
    @ElementCollection
    private List<Integer> previousFixturesBlocks = new ArrayList<>();

//    private Integer previousFixturesClearancesBlocksInterceptions1;
//    private Integer previousFixturesClearancesBlocksInterceptions2;
//    private Integer previousFixturesClearancesBlocksInterceptions3;
    @ElementCollection
    private List<Integer> previousFixturesRecoveries = new ArrayList<>();

//    private Integer previousFixturesRecoveries1;
//    private Integer previousFixturesRecoveries2;
//    private Integer previousFixturesRecoveries3;
    @ElementCollection
    private List<Integer> previousFixturesKeyPasses = new ArrayList<>();

//    private Integer previousFixturesKeyPasses1;
//    private Integer previousFixturesKeyPasses2;
//    private Integer previousFixturesKeyPasses3;
    @ElementCollection
    private List<Integer> previousFixturesTackles = new ArrayList<>();

//    private Integer previousFixturesTackles1;
//    private Integer previousFixturesTackles2;
//    private Integer previousFixturesTackles3;
    @ElementCollection
    private List<Integer> previousFixturesWinningGoals = new ArrayList<>();

//    private Integer previousFixturesWinningGoals1;
//    private Integer previousFixturesWinningGoals2;
//    private Integer previousFixturesWinningGoals3;
    @ElementCollection
    private List<Integer> previousFixturesFatalErrors = new ArrayList<>();

//    private Integer previousFixturesErrorsLeadingToGoal1;
//    private Integer previousFixturesErrorsLeadingToGoal2;
//    private Integer previousFixturesErrorsLeadingToGoal3;
    @ElementCollection
    private List<Integer> previousFixturesErrors = new ArrayList<>();

//    private Integer previousFixturesErrorsLeadingToGoalAttempt1;
//    private Integer previousFixturesErrorsLeadingToGoalAttempt2;
//    private Integer previousFixturesErrorsLeadingToGoalAttempt3;
    @ElementCollection
    private List<Integer> previousFixturesTackled = new ArrayList<>();

//    private Integer previousFixturesTackled1;
//    private Integer previousFixturesTackled2;
//    private Integer previousFixturesTackled3;
    @ElementCollection
    private List<Integer> previousFixturesFouls = new ArrayList<>();

//    private Integer previousFixturesFouls1;
//    private Integer previousFixturesFouls2;
//    private Integer previousFixturesFouls3;
    @ElementCollection
    private List<Integer> previousFixturesDribbles = new ArrayList<>();

//    private Integer previousFixturesDribbles1;
//    private Integer previousFixturesDribbles2;
//    private Integer previousFixturesDribbles3;


    public List<Integer> getPreviousFixturesGoals() {
        return previousFixturesGoals;
    }

    public void setPreviousFixturesGoals(List<Integer> previousFixturesGoals) {
        this.previousFixturesGoals = previousFixturesGoals;
    }

    public List<Integer> getPreviousFixturesAssists() {
        return previousFixturesAssists;
    }

    public void setPreviousFixturesAssists(List<Integer> previousFixturesAssists) {
        this.previousFixturesAssists = previousFixturesAssists;
    }

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

    public List<Integer> getPreviousFixturesChancesCreated() {
        return previousFixturesChancesCreated;
    }

    public void setPreviousFixturesChancesCreated(List<Integer> previousFixturesChancesCreated) {
        this.previousFixturesChancesCreated = previousFixturesChancesCreated;
    }

    public List<Integer> getPreviousFixturesBlocks() {
        return previousFixturesBlocks;
    }

    public void setPreviousFixturesBlocks(List<Integer> previousFixturesBlocks) {
        this.previousFixturesBlocks = previousFixturesBlocks;
    }

    public List<Integer> getPreviousFixturesRecoveries() {
        return previousFixturesRecoveries;
    }

    public void setPreviousFixturesRecoveries(List<Integer> previousFixturesRecoveries) {
        this.previousFixturesRecoveries = previousFixturesRecoveries;
    }

    public List<Integer> getPreviousFixturesKeyPasses() {
        return previousFixturesKeyPasses;
    }

    public void setPreviousFixturesKeyPasses(List<Integer> previousFixturesKeyPasses) {
        this.previousFixturesKeyPasses = previousFixturesKeyPasses;
    }

    public List<Integer> getPreviousFixturesTackles() {
        return previousFixturesTackles;
    }

    public void setPreviousFixturesTackles(List<Integer> previousFixturesTackles) {
        this.previousFixturesTackles = previousFixturesTackles;
    }

    public List<Integer> getPreviousFixturesWinningGoals() {
        return previousFixturesWinningGoals;
    }

    public void setPreviousFixturesWinningGoals(List<Integer> previousFixturesWinningGoals) {
        this.previousFixturesWinningGoals = previousFixturesWinningGoals;
    }

    public List<Integer> getPreviousFixturesFatalErrors() {
        return previousFixturesFatalErrors;
    }

    public void setPreviousFixturesFatalErrors(List<Integer> previousFixturesFatalErrors) {
        this.previousFixturesFatalErrors = previousFixturesFatalErrors;
    }

    public List<Integer> getPreviousFixturesErrors() {
        return previousFixturesErrors;
    }

    public void setPreviousFixturesErrors(List<Integer> previousFixturesErrors) {
        this.previousFixturesErrors = previousFixturesErrors;
    }

    public List<Integer> getPreviousFixturesTackled() {
        return previousFixturesTackled;
    }

    public void setPreviousFixturesTackled(List<Integer> previousFixturesTackled) {
        this.previousFixturesTackled = previousFixturesTackled;
    }

    public List<Integer> getPreviousFixturesFouls() {
        return previousFixturesFouls;
    }

    public void setPreviousFixturesFouls(List<Integer> previousFixturesFouls) {
        this.previousFixturesFouls = previousFixturesFouls;
    }

    public List<Integer> getPreviousFixturesDribbles() {
        return previousFixturesDribbles;
    }

    public void setPreviousFixturesDribbles(List<Integer> previousFixturesDribbles) {
        this.previousFixturesDribbles = previousFixturesDribbles;
    }

    @Override
    public String toString() {
        return "DefenderStatisticsSample{" +
                "previousFixturesGoals=" + previousFixturesGoals +
                ", previousFixturesAssists=" + previousFixturesAssists +
                ", previousFixturesCleanSheets=" + previousFixturesCleanSheets +
                ", previousFixturesGoalsConceded=" + previousFixturesGoalsConceded +
                ", previousFixturesChancesCreated=" + previousFixturesChancesCreated +
                ", previousFixturesBlocks=" + previousFixturesBlocks +
                ", previousFixturesRecoveries=" + previousFixturesRecoveries +
                ", previousFixturesKeyPasses=" + previousFixturesKeyPasses +
                ", previousFixturesTackles=" + previousFixturesTackles +
                ", previousFixturesWinningGoals=" + previousFixturesWinningGoals +
                ", previousFixturesFatalErrors=" + previousFixturesFatalErrors +
                ", previousFixturesErrors=" + previousFixturesErrors +
                ", previousFixturesTackled=" + previousFixturesTackled +
                ", previousFixturesFouls=" + previousFixturesFouls +
                ", previousFixturesDribbles=" + previousFixturesDribbles +
                '}';
    }
}
