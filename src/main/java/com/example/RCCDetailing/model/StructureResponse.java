package com.example.RCCDetailing.model;

import java.util.List;

public class StructureResponse {
    List<Beam> beams;
    List<Column> columns;
    List<ColumnLineResponse> columnLineResponses;

    public StructureResponse(List<Beam> beams, List<Column> columns, List<ColumnLineResponse> columnLineResponses) {
        this.beams = beams;
        this.columns = columns;
        this.columnLineResponses = columnLineResponses;
    }

    public List<Beam> getBeams() {
        return beams;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public List<ColumnLineResponse> getColumnLineResponses() {
        return columnLineResponses;
    }
}
