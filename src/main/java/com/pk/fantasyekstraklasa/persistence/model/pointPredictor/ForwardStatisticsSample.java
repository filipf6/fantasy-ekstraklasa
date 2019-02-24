package com.pk.fantasyekstraklasa.persistence.model.pointPredictor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "forward_statistics_sample")
public class ForwardStatisticsSample extends PlayerStatisticsSample {
    @ElementCollection
    private List<Integer> previousFixturesGoals = new ArrayList<>();
    @ElementCollection
    private List<Integer> previousFixturesAssists = new ArrayList<>();
    @ElementCollection
    private List<Integer> previousFixturesChancesCreated = new ArrayList<>();
    @ElementCollection
    private List<Integer> previousFixturesKeyPasses = new ArrayList<>();
    @ElementCollection
    private List<Integer> previousFixturesWinningGoals = new ArrayList<>();
    @ElementCollection
    private List<Integer> previousFixturesChancesMissed = new ArrayList<>();
    @ElementCollection
    private List<Integer> previousFixturesTackled = new ArrayList<>();
    @ElementCollection
    private List<Integer> previousFixturesFouls = new ArrayList<>();
    @ElementCollection
    private List<Integer> previousFixturesDribbles = new ArrayList<>();

//    private Integer previousFixturesGoals1;
//    private Integer previousFixturesGoals2;
//    private Integer previousFixturesGoals3;
//    private Integer previousFixturesAssists1;
//    private Integer previousFixturesAssists2;
//    private Integer previousFixturesAssists3;
//    private Integer previousFixturesBigChancesCreated1;
//    private Integer previousFixturesBigChancesCreated2;
//    private Integer previousFixturesBigChancesCreated3;
//    private Integer previousFixturesKeyPasses1;
//    private Integer previousFixturesKeyPasses2;
//    private Integer previousFixturesKeyPasses3;
//    private Integer previousFixturesWinningGoals1;
//    private Integer previousFixturesWinningGoals2;
//    private Integer previousFixturesWinningGoals3;
//    private Integer previousFixturesBigChancesMissed1;
//    private Integer previousFixturesBigChancesMissed2;
//    private Integer previousFixturesBigChancesMissed3;
//    private Integer previousFixturesTackled1;
//    private Integer previousFixturesTackled2;
//    private Integer previousFixturesTackled3;
//    private Integer previousFixturesFouls1;
//    private Integer previousFixturesFouls2;
//    private Integer previousFixturesFouls3;
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

    public List<Integer> getPreviousFixturesChancesCreated() {
        return previousFixturesChancesCreated;
    }

    public void setPreviousFixturesChancesCreated(List<Integer> previousFixturesChancesCreated) {
        this.previousFixturesChancesCreated = previousFixturesChancesCreated;
    }

    public List<Integer> getPreviousFixturesKeyPasses() {
        return previousFixturesKeyPasses;
    }

    public void setPreviousFixturesKeyPasses(List<Integer> previousFixturesKeyPasses) {
        this.previousFixturesKeyPasses = previousFixturesKeyPasses;
    }

    public List<Integer> getPreviousFixturesWinningGoals() {
        return previousFixturesWinningGoals;
    }

    public void setPreviousFixturesWinningGoals(List<Integer> previousFixturesWinningGoals) {
        this.previousFixturesWinningGoals = previousFixturesWinningGoals;
    }

    public List<Integer> getPreviousFixturesChancesMissed() {
        return previousFixturesChancesMissed;
    }

    public void setPreviousFixturesChancesMissed(List<Integer> previousFixturesChancesMissed) {
        this.previousFixturesChancesMissed = previousFixturesChancesMissed;
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
        return "ForwardStatisticsSample{" +
                "previousFixturesGoals=" + previousFixturesGoals +
                ", previousFixturesAssists=" + previousFixturesAssists +
                ", previousFixturesChancesCreated=" + previousFixturesChancesCreated +
                ", previousFixturesKeyPasses=" + previousFixturesKeyPasses +
                ", previousFixturesWinningGoals=" + previousFixturesWinningGoals +
                ", previousFixturesChancesMissed=" + previousFixturesChancesMissed +
                ", previousFixturesTackled=" + previousFixturesTackled +
                ", previousFixturesFouls=" + previousFixturesFouls +
                ", previousFixturesDribbles=" + previousFixturesDribbles +
                '}';
    }
}


