package com.example.RCCDetailing.model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStructure {
    private List<Beam> beams;
    private List<Column> columns;

    public AbstractStructure(){
        beams = new ArrayList<>();
        columns = new ArrayList<>();
    }

    public List<Beam> getBeams() {
        return beams;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void addBeam(Beam beam){
        this.beams.add(beam);
    }
    public void addColumn(Column column){
        this.columns.add(column);
    }

    public void addSegment(Segment segment){
        if(segment.type== SegmentType.BEAM){
            this.beams.add((Beam)segment);
        }
        else if(segment.type==SegmentType.COLUMN){
            this.columns.add((Column) segment);
        }
    }

}