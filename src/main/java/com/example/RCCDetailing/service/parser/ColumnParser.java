package com.example.RCCDetailing.service.parser;

import com.example.RCCDetailing.model.*;
import com.example.RCCDetailing.service.util.ParseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ColumnParser {
    private final Properties properties = ParseUtil.getInstance().getProperties();
    private final List<String> lines = new ArrayList<>();
    public Column parse(String section){
        Column column = new Column();
        String[] ar = section.split("\n+");
        for(String s: ar){
            lines.add(s.trim());
        }
        column.setSegmentNumber(getColumnNumber());
        column.setConcreteGrade(getConcreteGrade(section));
        column.setMainReinforcementGrade(getMainReinforcementGrade(section));
        column.setTieReinforcementGrade(getTieReinforcementGrade(section));
        if(!isPass(section)){
            column.setPass(false);
            return column;
        }
        column.setPass(true);

        column.setLength(getLength(section));
        column.setCrossSection(getCrossSection(section));
        column.setCover(getCover(section));
        column.setRequiredSteelArea(getRequiredSteelArea(section));
        column.setTieReinforcement(getTieReinforcement(section));
        return column;
    }

    private boolean isPass(String section){
        return !section.contains(properties.getProperty("column_fail_identifier"));
    }
    private int getColumnNumber(){
        String line = lines.get(1);
        return Integer.parseInt(line.split("\\s+")[8]);
    }
    private ConcreteGrade getConcreteGrade(String section){
        String line = this.lines.get(2);
        String value = line.split("\\s+")[0];
        switch (value) {
            case "M15" : {
                return ConcreteGrade.M15;
            }
            case "M20" : {
                return ConcreteGrade.M20;
            }
            case "M25" : {
                return ConcreteGrade.M25;
            }
            case "M30" : {
                return ConcreteGrade.M30;
            }
            case "M35" : {
                return ConcreteGrade.M35;
            }
        }
        return null;
    }
    private MainReinforcementGrade getMainReinforcementGrade(String section){
        String line = this.lines.get(2);
        String value = line.split("\\s+")[1];
        if(value.equals("Fe415"))
            return MainReinforcementGrade.Fe415;
        if(value.equals("Fe500"))
            return MainReinforcementGrade.Fe500;
        return null;
    }
    private TieReinforcement getTieReinforcement(String section){
        String line = "";
        for(String l: lines){
            if(l.contains(properties.getProperty("tie_reinforcement_identifier"))){
                line =l;
                break;
            }
        }
        String[] values = line.split("\\s+");
        return new TieReinforcement(Integer.parseInt(values[4]),Integer.parseInt(values[10]));
    }

    private double getLength(String section){
        String line = this.lines.get(3);
        String value = line.split("\\s+")[1];
        return Double.parseDouble(value);
    }
    private double[] getCrossSection(String section){
        String line = lines.get(3);
        String[] values = line.split("\\s+");
        double[] ans = new double[2];
        ans[0] = Double.parseDouble(values[5]);
        ans[1] = Character.isDigit(values[8].charAt(0))? Double.parseDouble(values[8]): ans[0];

        return ans;
    }

    private double getCover(String section){
        String line = this.lines.get(3);
        String[] values = line.split("\\s+");
        for(int i=0; i<values.length; i++){
            if(values[i].startsWith("COVER:")){
                return Double.parseDouble(values[i+1]);
            }
        }
        return 0;

    }

    private TieReinforcementGrade getTieReinforcementGrade(String section){
        String line = this.lines.get(2);
        String value = line.split("\\s+")[3];
        if(value.equals("Fe415"))
            return TieReinforcementGrade.Fe415;
        if(value.equals("Fe500"))
            return TieReinforcementGrade.Fe500;
        return null;
    }
    private double getRequiredSteelArea(String section){
        String line = "";
        for(String l: lines){
            if(l.contains(properties.getProperty("required_steel_area_identifier"))){
                line =l;
                break;
            }
        }
        //System.out.println(line);
        int len = line.split("\\s++").length;

        return Double.parseDouble(line.split("\\s++")[4]);
    }
}
