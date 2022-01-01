package com.example.RCCDetailing.model;

import java.util.List;

public class ColumnLineResponse {
    int nodeNumber;
    double[] crossSection;
    double maxRequiredSteelArea;
    List<Double> requiredSteelAreas;

    public ColumnLineResponse(int nodeNumber, double[] crossSection, double maxRequiredSteelArea, List<Double> requiredSteelAreas) {
        this.nodeNumber = nodeNumber;
        this.crossSection = crossSection;
        this.maxRequiredSteelArea = maxRequiredSteelArea;
        this.requiredSteelAreas = requiredSteelAreas;
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public double[] getCrossSection() {
        return crossSection;
    }

    public double getMaxRequiredSteelArea() {
        return maxRequiredSteelArea;
    }

    public List<Double> getRequiredSteelAreas() {
        return requiredSteelAreas;
    }
}
