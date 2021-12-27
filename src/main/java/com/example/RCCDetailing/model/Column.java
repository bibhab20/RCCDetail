package com.example.RCCDetailing.model;

import java.util.Arrays;

public class Column extends Segment{
    private double length;
    private double[] crossSection;
    private double cover;
    private double requiredSteelArea;
    private TieReinforcement tieReinforcement;
    private MainReinforcementGrade mainReinforcementGrade;
    private TieReinforcementGrade tieReinforcementGrade;
    private ConcreteGrade concreteGrade;


    public Column(){
        this.type = SegmentType.COLUMN;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double[] getCrossSection() {
        return crossSection;
    }

    public void setCrossSection(double[] crossSection) {
        this.crossSection = crossSection;
    }

    public double getCover() {
        return cover;
    }

    public void setCover(double cover) {
        this.cover = cover;
    }

    public double getRequiredSteelArea() {
        return requiredSteelArea;
    }

    public void setRequiredSteelArea(double requiredSteelArea) {
        this.requiredSteelArea = requiredSteelArea;
    }

    public TieReinforcement getTieReinforcement() {
        return tieReinforcement;
    }

    public void setTieReinforcement(TieReinforcement tieReinforcement) {
        this.tieReinforcement = tieReinforcement;
    }

    public MainReinforcementGrade getMainReinforcementGrade() {
        return mainReinforcementGrade;
    }

    public void setMainReinforcementGrade(MainReinforcementGrade mainReinforcementGrade) {
        this.mainReinforcementGrade = mainReinforcementGrade;
    }

    public TieReinforcementGrade getTieReinforcementGrade() {
        return tieReinforcementGrade;
    }

    public void setTieReinforcementGrade(TieReinforcementGrade tieReinforcementGrade) {
        this.tieReinforcementGrade = tieReinforcementGrade;
    }

    public ConcreteGrade getConcreteGrade() {
        return concreteGrade;
    }

    public void setConcreteGrade(ConcreteGrade concreteGrade) {
        this.concreteGrade = concreteGrade;
    }

    @Override
    public String toString() {
        return "Column{" +
                "length=" + length +
                ", crossSection=" + Arrays.toString(crossSection) +
                ", cover=" + cover +
                ", requiredSteelArea=" + requiredSteelArea +
                ", tieReinforcement=" + tieReinforcement +
                ", mainReinforcementGrade=" + mainReinforcementGrade +
                ", tieReinforcementGrade=" + tieReinforcementGrade +
                ", concreteGrade=" + concreteGrade +
                '}';
    }
}