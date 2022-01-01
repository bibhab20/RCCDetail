package com.example.RCCDetailing.service.analysis;

import com.example.RCCDetailing.model.Column;
import com.example.RCCDetailing.model.ColumnLine;
import com.example.RCCDetailing.model.Structure;

import java.util.*;

public class ColumnLineAnalyzer {

    public List<ColumnLine> getColumnLines(Structure structure){
        List<Column> columns = structure.getColumns();
        Map<String, List<Column>> map = new HashMap<>();
        for(Column column: columns){
            String key = this.getHashKey(column);
            List<Column> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(column);
        }
        List<ColumnLine> columnLines = new ArrayList<>();
        for(List<Column> line: map.values()){
            ColumnLine columnLine = new ColumnLine(line);
            System.out.println(Arrays.toString(columnLine.getCrossSection()));
            columnLines.add(columnLine);
        }

        return columnLines;
    }

    private String getHashKey(Column column){
        String key = column.getIncidence().getStart().getCoordinate().getZ()+"";
        key += "*"+column.getIncidence().getStart().getCoordinate().getX();
        return key;
    }
}
