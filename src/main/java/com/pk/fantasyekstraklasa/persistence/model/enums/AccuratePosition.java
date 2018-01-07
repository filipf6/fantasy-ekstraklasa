package com.pk.fantasyekstraklasa.persistence.model.enums;

public enum AccuratePosition {
    GK, LB, CLB, CRB, RB, LM, CLM, CRM, RM, LS, RS;

    public static AccuratePosition buildAccuratePositionFromString(String accuratePosition) {
        switch(accuratePosition) {
            case "GK": return AccuratePosition.GK;
            case "LB": return AccuratePosition.LB;
            case "CLB": return AccuratePosition.CLB;
            case "CRB": return AccuratePosition.CRB;
            case "RB": return AccuratePosition.RB;
            case "LM": return AccuratePosition.LM;
            case "CLM": return AccuratePosition.CLM;
            case "CRM": return AccuratePosition.CRM;
            case "RM": return AccuratePosition.RM;
            case "LS": return AccuratePosition.LS;
            case "RS": return AccuratePosition.RS;
        }
        return null;
    }
}
