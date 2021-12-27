package com.example.RCCDetailing.service.parser;



import com.example.RCCDetailing.model.*;
import com.example.RCCDetailing.service.util.ParseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BeamParser {
    private final Properties properties = ParseUtil.getInstance().getProperties();
    private String section;
    private List<String> lines = new ArrayList<>();
    public Beam parse(String section){
        Beam beam = new Beam();
        String[] ar = section.split("\n+");
        for(String s: ar){
            lines.add(s.trim());
        }
        beam.setSegmentNumber(getBeamNumber());
        beam.setLength(getLength(section));
        beam.setSize(getSize(section));
        beam.setCover(getCover(section));
        if(!isPass(section)){
            beam.setPass(false);
            return beam;
        }
        beam.setPass(true);

        beam.setTopReinforcement(getTopReinforcement(section));
        beam.setBottomReinforcement(getBottomReinforcement(section));
        beam.setConcreteGrade(getConcreteGrade(section));

        beam.setMainReinforcementGrade(getMainReinforcement(section));
        beam.setShearReinforcement(getShearReinforcement(section));

        return beam;
    }

    private double getLength(String section){

        String line = this.lines.get(3);
        String value = line.split("\\s+")[1];
        return Double.parseDouble(value);
    }

    private double[] getSize(String section){
        String[] ar = section.split(properties.getProperty("size_identifier"));
        String[] values = ar[1].split("\\s+",6);
        double[] ans = new double[2];
        ans[0] = Double.parseDouble(values[1]);
        ans[1] = Double.parseDouble(values[4]);
        return ans;

    }
    private int getBeamNumber(){
        String line = lines.get(1).trim();

        return Integer.parseInt(line.split("\\s+")[6]);
    }

    private TopReinforcement getTopReinforcement(String section){
        String line ="";
        for(int i=0; i<lines.size(); i++){
            if(lines.get(i).contains(properties.getProperty("summary_of_reinforced_identifier"))){
                line = lines.get(i+4);
                break;
            }
        }
        //System.out.println(line);
        String[] values = line.split("\\s+");
        if(!values[0].equals("TOP"))
            return null;
        TopReinforcement topReinforcement = new TopReinforcement();
        topReinforcement.setStart(Math.max(Double.parseDouble(values[1]),Double.parseDouble(values[2])));
        topReinforcement.setMid(Math.max(Double.parseDouble(values[3]),Double.parseDouble(values[4])));
        topReinforcement.setMid(Double.parseDouble(values[5]));
        return topReinforcement;

    }
    private double getBottomReinforcement(String section){
        String line ="";
        for(String l : lines){
            if(l.contains(properties.getProperty("bottom_reinforcement_identifier"))){
                line = l;
                break;
            }
        }
        String[] values = line.split("\\s+");
        if(!values[0].equals("BOTTOM"))
            return -1;
        double ans = Double.MIN_VALUE;
        for(int i=1; i<values.length; i++){
            ans = Math.max(ans, Double.parseDouble(values[i]));
        }
        return ans;
    }

    private double getCover(String section){
        String[] ar = section.split(properties.getProperty("cover_identifier"));
        String value = ar[1].split("mm",2)[0];
        return Double.parseDouble(value.trim());
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

    private MainReinforcementGrade getMainReinforcement(String section){
        String line = this.lines.get(2);
        String value = line.split("\\s+")[1];
        if(value.equals("Fe415"))
            return MainReinforcementGrade.Fe415;
        if(value.equals("Fe500"))
            return MainReinforcementGrade.Fe500;
        return null;
    }
    private List<StirreupSpecification> getShearReinforcement(String section){
        String line1 = "", line2 ="";
        for(int i=0; i<lines.size(); i++){
            if(lines.get(i).contains(properties.getProperty("shear_reinforcement_identifier"))){
                line1 = lines.get(i);
                line2 = lines.get(i+1);
                break;
            }
        }

        List<StirreupSpecification> list = new ArrayList<>();
        String[] ar = line1.split("\\s++");
        for(int i=1; i<ar.length; i++){
            if(ar[i].equals("legged")){
                StirreupSpecification specification = new StirreupSpecification();
                specification.setLeg(Integer.parseInt(ar[i-1]));
                specification.setDiameter(Integer.parseInt(ar[i+1].substring(0,ar[i+1].length()-1)));
                list.add(specification);
            }
        }

        String[] ar2 = line2.split("\\s+");
        int index =0;
        for(String s: ar2){
            if(Character.isDigit(s.charAt(0))){
                list.get(index++).setSpacing(Integer.parseInt(s));
            }
        }
        return list;
    }

    private boolean isPass(String section){
        boolean value = section.contains(properties.getProperty("beam_fail_identifier"));
        return !value;
    }

    private ShearReinforcementGrade getShearReinforcementGrade(){
        String line = this.lines.get(2);
        String value = line.split("\\s+")[3];
        if(value.equals("Fe415"))
            return ShearReinforcementGrade.Fe415;
        if(value.equals("Fe500"))
            return ShearReinforcementGrade.Fe500;
        return null;
    }
}
