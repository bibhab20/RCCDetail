package com.example.RCCDetailing.service;

import com.example.RCCDetailing.model.ColumnLine;
import com.example.RCCDetailing.model.ColumnLineResponse;
import com.example.RCCDetailing.model.Structure;
import com.example.RCCDetailing.model.StructureResponse;

import java.util.ArrayList;
import java.util.List;

public class StructureResponseAdapter {

    public StructureResponse getStructureResponse(Structure structure, List<ColumnLine> columnLines){
        List<ColumnLineResponse> columnLineResponses = new ArrayList<>();
        for(ColumnLine columnLine: columnLines){
            ColumnLineResponse columnLineResponse = new ColumnLineResponse(columnLine.getNodeNumber(),
                    columnLine.getCrossSection(),columnLine.getMaxRequiredSteelArea(),columnLine.getRequiredSteelAreas());
            columnLineResponses.add(columnLineResponse);
        }
        return new StructureResponse(structure.getBeams(),structure.getColumns(), columnLineResponses);

    }
}
