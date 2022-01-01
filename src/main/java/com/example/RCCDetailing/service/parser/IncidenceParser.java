package com.example.RCCDetailing.service.parser;

import com.example.RCCDetailing.model.Incidence;
import com.example.RCCDetailing.model.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IncidenceParser {
    public Map<Integer, Incidence> parseIncidence(List<String> lines, List<Node> nodes){
        Map<Integer, Incidence> map = new HashMap<>();
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (Node node: nodes){
            nodeMap.put(node.getNodeNumber(), node);
        }
        for(String line: lines){
            String[] ar = line.split(";");
            for(String s: ar){
                String[] temp = s.split("\\s+");
                int l = temp.length;
                int segmentNumber = Integer.parseInt(temp[l-3]);
                int startNode = Integer.parseInt(temp[l-2]);
                int endNode = Integer.parseInt(temp[l-1]);
                Incidence incidence = new Incidence(nodeMap.get(startNode), nodeMap.get(endNode));
                map.put(segmentNumber, incidence);
            }
        }
        return map;
    }
}
