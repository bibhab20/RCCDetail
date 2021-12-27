package com.example.RCCDetailing.model;

import java.util.Arrays;
import java.util.List;

public class Beam extends Segment{
    private double length;
    private double[] size;
    private TopReinforcement topReinforcement;
    private double bottomReinforcement;
    private double cover;
    ConcreteGrade concreteGrade;
    MainReinforcementGrade mainReinforcementGrade;
    ShearReinforcementGrade shearReinforcementGrade;
    List<StirreupSpecification> shearReinforcement;

    public Beam(){
        this.type = SegmentType.BEAM;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double[] getSize() {
        return size;
    }

    public void setSize(double[] size) {
        this.size = size;
    }

    public TopReinforcement getTopReinforcement() {
        return topReinforcement;
    }

    public void setTopReinforcement(TopReinforcement topReinforcement) {
        this.topReinforcement = topReinforcement;
    }

    public double getBottomReinforcement() {
        return bottomReinforcement;
    }

    public void setBottomReinforcement(double bottomReinforcement) {
        this.bottomReinforcement = bottomReinforcement;
    }

    public double getCover() {
        return cover;
    }

    public void setCover(double cover) {
        this.cover = cover;
    }

    public ConcreteGrade getConcreteGrade() {
        return concreteGrade;
    }

    public void setConcreteGrade(ConcreteGrade concreteGrade) {
        this.concreteGrade = concreteGrade;
    }

    public MainReinforcementGrade getMainReinforcementGrade() {
        return mainReinforcementGrade;
    }

    public void setMainReinforcementGrade(MainReinforcementGrade mainReinforcementGrade) {
        this.mainReinforcementGrade = mainReinforcementGrade;
    }

    public ShearReinforcementGrade getShearReinforcementGrade() {
        return shearReinforcementGrade;
    }

    public void setShearReinforcementGrade(ShearReinforcementGrade shearReinforcementGrade) {
        this.shearReinforcementGrade = shearReinforcementGrade;
    }

    public List<StirreupSpecification> getShearReinforcement() {
        return shearReinforcement;
    }

    public void setShearReinforcement(List<StirreupSpecification> shearReinforcement) {
        this.shearReinforcement = shearReinforcement;
    }

    @Override
    public String toString() {
        return "Beam{" +
                "length=" + length +
                ", size=" + Arrays.toString(size) +
                ", topReinforcement=" + topReinforcement +
                ", bottomReinforcement=" + bottomReinforcement +
                ", cover=" + cover +
                ", concreteGrade=" + concreteGrade +
                ", mainReinforcementGrade=" + mainReinforcementGrade +
                ", shearReinforcementGrade=" + shearReinforcementGrade +
                ", shearReinforcement=" + shearReinforcement +
                '}';
    }
}
