package com.example.RCCDetailing.model;

public class TieReinforcement {
    private int diameter,tie;

    public TieReinforcement(int diameter, int tie) {
        this.diameter = diameter;
        this.tie = tie;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getTie() {
        return tie;
    }

    public void setTie(int tie) {
        this.tie = tie;
    }
}
