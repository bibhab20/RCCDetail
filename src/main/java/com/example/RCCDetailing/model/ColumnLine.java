package com.example.RCCDetailing.model;

import java.util.ArrayList;
import java.util.List;

public class ColumnLine {
    List<Column> columns;
    double maxRequiredSteelArea;

    public ColumnLine(List<Column> columns){
        this.setColumns(columns);
        this.setMaximumRequiredSteelArea();
    }

    private void setColumns(List<Column> columns){
        if(columns ==  null)
            columns = new ArrayList<>();
        columns.sort((a, b) -> {
            return (int) (a.getIncidence().getStart().getCoordinate().getY() - b.getIncidence().getStart().getCoordinate().getY());
        });
        this.columns = columns;
    }
    private void setMaximumRequiredSteelArea(){
        double max = 0;
        assert this.columns != null;
        for(Column column: this.columns){
            max = Math.max(max, column.getRequiredSteelArea());
        }
        this.maxRequiredSteelArea = max;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public double getMaxRequiredSteelArea() {
        return maxRequiredSteelArea;
    }

    public double[] getCrossSection(){
        return this.columns.get(0).getCrossSection();
    }
    public int getNodeNumber(){
        return this.columns.get(0).getIncidence().getStart().getNodeNumber();
    }

    public List<Double> getRequiredSteelAreas(){
        List<Double> ans = new ArrayList<>();
        for(Column column: this.columns){
            ans.add(column.getRequiredSteelArea());
        }
        return ans;
    }
}
