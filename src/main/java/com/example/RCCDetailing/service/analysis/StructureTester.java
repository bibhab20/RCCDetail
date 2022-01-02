package com.example.RCCDetailing.service.analysis;

import com.example.RCCDetailing.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StructureTester {

    public Report getReport(Structure structure){
        Report report = new Report();
        addBasicReport(structure, report);
        addBeamsReport(structure,report);
        addColumnsReport(structure,report);
        return report;
    }

    private void addBasicReport(Structure structure, Report report){
        if(structure == null){
            report.addLog(new ReportLog(LogType.ERROR,"basic","Structure is null"));
            return;
        }
        report.addLog(new ReportLog(LogType.SUCCESS, "basic","Structure is not null"));

    }

    private void addBeamsReport(Structure structure, Report report){
        if(structure.getBeams() == null){
            report.addLog(new ReportLog(LogType.ERROR,"beams","Beams is null"));
            return;
        }
        report.addLog(new ReportLog(LogType.SUCCESS, "beams","Beams is not null"));
        List<Beam> beams = structure.getBeams();
        int noOfBeams = beams.size();
        report.addLog(new ReportLog(LogType.INFO, "beams","No of beams found"+noOfBeams));
        int nullCount =0;
        int noSegmentNumberCount = 0;
        List<Integer> invalidIncidence = new ArrayList<>();
        List<Integer> invalidStartNode = new ArrayList<>();
        List<Integer> invalidEndNode = new ArrayList<>();
        List<Integer> invalidCoordinate = new ArrayList<>();
        List<Integer> invalidLength = new ArrayList<>();
        List<Integer> invalidSize = new ArrayList<>();
        List<Integer> invalidTopReinforcement = new ArrayList<>();
        List<Integer> invalidBottomReinforcement = new ArrayList<>();
        List<Integer> invalidCover = new ArrayList<>();
        List<Integer> invalidConcreteGrade = new ArrayList<>();
        List<Integer> invalidMainReinforcementGrade = new ArrayList<>();
        List<Integer> invalidShearReinforcementGrade = new ArrayList<>();
        List<Integer> invalidShearReinforcement = new ArrayList<>();
        List<Integer> fail = new ArrayList<>();

        for (int i = 0; i<noOfBeams; i++){
            Beam beam = beams.get(i);
            if(beam == null){
                report.addLog(new ReportLog(LogType.ERROR,"beam",""+i+"th beam found to be null"));
                nullCount++;
                continue;
            }
            if(beam.getSegmentNumber() == 0){
                noSegmentNumberCount++;
                continue;
            }
            if(!beam.isPass()){
                fail.add(beam.getSegmentNumber());
            }
            if(beam.getIncidence() == null){
                invalidIncidence.add(beam.getSegmentNumber());
            }
            if(beam.getIncidence() != null && beam.getIncidence().getStart()== null){
                invalidStartNode.add(beam.getSegmentNumber());
            }
            else if (beam.getIncidence() != null && beam.getIncidence().getStart().getCoordinate() == null){
                invalidCoordinate.add(beam.getSegmentNumber());
            }
            if(beam.getIncidence() != null && beam.getIncidence().getEnd()== null){
                invalidEndNode.add(beam.getSegmentNumber());
            }
            else if (beam.getIncidence() != null && beam.getIncidence().getEnd().getCoordinate() == null){
                invalidCoordinate.add(beam.getSegmentNumber());
            }
            if(beam.getLength() == 0){
                invalidLength.add(beam.getSegmentNumber());
            }
            if(beam.getSize() == null){
                invalidSize.add(beam.getSegmentNumber());
            }
            if(beam.getTopReinforcement() == null){
                invalidTopReinforcement.add(beam.getSegmentNumber());
            }
            if(beam.getBottomReinforcement() == 0){
                invalidBottomReinforcement.add(beam.getSegmentNumber());
            }
            if(beam.getCover() == 0){
                invalidCover.add(beam.getSegmentNumber());
            }
            if(beam.getConcreteGrade() == null){
                invalidConcreteGrade.add(beam.getSegmentNumber());
            }
            if(beam.getMainReinforcementGrade() == null){
                invalidMainReinforcementGrade.add(beam.getSegmentNumber());
            }
            if(beam.getShearReinforcementGrade() == null){
                invalidShearReinforcementGrade.add(beam.getSegmentNumber());
            }
            if(beam.getShearReinforcement() == null || beam.getShearReinforcement().size() == 0){
                invalidShearReinforcement.add(beam.getSegmentNumber());
            }

        }

        report.addLog(new ReportLog(LogType.INFO, "beams","Number of beams with null value: "+nullCount));
        report.addLog(new ReportLog(LogType.INFO,"beams","Number of beams failed: "+fail.size()));
        report.addLog(new ReportLog(LogType.INFO,"beams","Number of beams without segmentNumber: "+noSegmentNumberCount));
        report.addLog(new ReportLog(LogType.INFO, "beams",getLogMessage(invalidIncidence,"beams","Incidence")));
        report.addLog(new ReportLog(LogType.INFO, "beams",getLogMessage(invalidStartNode,"beams","Start Node")));
        report.addLog(new ReportLog(LogType.INFO, "beams",getLogMessage(invalidEndNode,"beams","End Node")));
        report.addLog(new ReportLog(LogType.INFO, "beams",getLogMessage(invalidCoordinate,"beams","Coordinate")));
        report.addLog(new ReportLog(LogType.INFO, "beams",getLogMessage(invalidLength,"beams","Length")));
        report.addLog(new ReportLog(LogType.INFO, "beams",getLogMessage(invalidSize,"beams","Size")));
        report.addLog(new ReportLog(LogType.INFO, "beams",getLogMessage(invalidTopReinforcement,"beams","Top Reinforcement")));
        report.addLog(new ReportLog(LogType.INFO, "beams",getLogMessage(invalidBottomReinforcement,"beams","Bottom Reinforcement")));
        report.addLog(new ReportLog(LogType.INFO, "beams",getLogMessage(invalidCover,"beams","Cover")));
        report.addLog(new ReportLog(LogType.INFO, "beams",getLogMessage(invalidConcreteGrade,"beams","Concrete Grade")));
        report.addLog(new ReportLog(LogType.INFO, "beams",getLogMessage(invalidMainReinforcementGrade,"beams","MainReinforcementGrade")));
        report.addLog(new ReportLog(LogType.INFO, "beams",getLogMessage(invalidShearReinforcementGrade,"beams","ShearReinforcementGrade")));
        report.addLog(new ReportLog(LogType.INFO, "beams",getLogMessage(invalidShearReinforcement,"beams","ShearReinforcement")));



    }

    private void addColumnsReport(Structure structure, Report report){
        if(structure.getColumns() == null){
            report.addLog(new ReportLog(LogType.ERROR,"columns","Columns is null"));
            return;
        }
        report.addLog(new ReportLog(LogType.SUCCESS, "columns","Columns is not null"));
        List<Column> columns = structure.getColumns();
        int noOfColumns = columns.size();
        report.addLog(new ReportLog(LogType.INFO, "columns","No of beams found"+noOfColumns));
        int nullCount =0;
        int noSegmentNumberCount = 0;

        Map<String, List<Integer>> attributeMap = new HashMap<>();
        attributeMap.put("segmentNumber", new ArrayList<>());
        attributeMap.put("incidence", new ArrayList<>());
        attributeMap.put("start node", new ArrayList<>());
        attributeMap.put("end node", new ArrayList<>());
        attributeMap.put("coordinate", new ArrayList<>());
        attributeMap.put("length", new ArrayList<>());
        attributeMap.put("crossSection", new ArrayList<>());
        attributeMap.put("cover", new ArrayList<>());
        attributeMap.put("requiredSteelArea", new ArrayList<>());
        attributeMap.put("tieReinforcement", new ArrayList<>());
        attributeMap.put("mainReinforcementGrade", new ArrayList<>());
        attributeMap.put("tieReinforcementGrade", new ArrayList<>());
        attributeMap.put("concreteGrade", new ArrayList<>());
        attributeMap.put("pass", new ArrayList<>());

        for(int i=0; i<noOfColumns; i++){
            Column column = columns.get(i);
            int segmentNumber;
            if(column == null){
                report.addLog(new ReportLog(LogType.ERROR,"column",""+i+"th column found to be null"));
                nullCount++;
                continue;

            }
            if(column.getSegmentNumber() == 0){
                noSegmentNumberCount++;
                continue;
            }
            else
                segmentNumber = column.getSegmentNumber();
            if(!column.isPass()){
                attributeMap.get("pass").add(i);
            }

            if(column.getIncidence() == null){
                attributeMap.get("incidence").add(i);
            }
            else{
                if(column.getIncidence().getStart() == null)
                    attributeMap.get("start node").add(segmentNumber);
                else if(column.getIncidence().getStart().getCoordinate() == null)
                    attributeMap.get("coordinate").add(segmentNumber);
                if(column.getIncidence().getEnd() == null)
                    attributeMap.get("end node").add(segmentNumber);
                else if(column.getIncidence().getEnd().getCoordinate() == null)
                    attributeMap.get("coordinate").add(segmentNumber);

            }

            if(column.getLength() == 0){
                attributeMap.get("length").add(segmentNumber);
            }
            if(column.getCover() == 0){
                attributeMap.get("cover").add(segmentNumber);
            }
            if(column.getCrossSection() == null){
                attributeMap.get("crossSection").add(segmentNumber);
            }
            if(column.getIncidence() == null){
                attributeMap.get("incidence").add(segmentNumber);
            }
            if(column.getRequiredSteelArea() == 0){
                attributeMap.get("requiredSteelArea").add(segmentNumber);
            }
            if(column.getTieReinforcement() == null){
                attributeMap.get("tieReinforcement").add(segmentNumber);
            }
            if(column.getMainReinforcementGrade() == null){
                attributeMap.get("mainReinforcementGrade").add(segmentNumber);
            }
            if(column.getTieReinforcementGrade() == null){
                attributeMap.get("tieReinforcementGrade").add(segmentNumber);
            }
            if(column.getConcreteGrade() == null){
                attributeMap.get("concreteGrade").add(segmentNumber);
            }



        }
        report.addLog(new ReportLog(LogType.INFO, "beams","Number of beams with null value: "+nullCount));
        report.addLog(new ReportLog(LogType.INFO,"beams","Number of beams without segmentNumber: "+noSegmentNumberCount));

        for(Map.Entry<String, List<Integer>> entry: attributeMap.entrySet()){
            report.addLog(new ReportLog(LogType.INFO,"columns",getLogMessage(entry.getValue(),"column",entry.getKey())));
        }

    }
    private String getSegmentListString(List<Integer> segments){
        StringBuilder stringBuilder = new StringBuilder();
        for(int segment: segments){
            stringBuilder.append(", ").append(segment);
        }
        return stringBuilder.substring(2);
    }
    private String getLogMessage(List<Integer> segments,String segmentType, String attribute){
        StringBuilder stringBuilder = new StringBuilder("No of ").append(segmentType);
        stringBuilder.append(" found with invalid ").append(attribute).append(": ").append(segments.size());
        if(segments.size()!= 0){
            stringBuilder.append(" Segment Numbers: ").append(getSegmentListString(segments));
        }
        return stringBuilder.toString();
    }
}
