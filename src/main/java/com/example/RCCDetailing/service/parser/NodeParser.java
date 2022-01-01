package com.example.RCCDetailing.service.parser;

import com.example.RCCDetailing.model.Node;

import java.util.ArrayList;
import java.util.List;

public class NodeParser {

    public List<Node> parseNodes(List<String> lines){
        List<Node> ans = new ArrayList<>();
        for(String line: lines){
            String[] ar = line.split(";");
            for(String s: ar){
                String[] temp = s.split("\\s+");
                int l = temp.length;
                double x = Double.parseDouble(temp[l-3]);
                double y = Double.parseDouble(temp[l-2]);
                double z = Double.parseDouble(temp[l-1]);
                int nodeNumber = Integer.parseInt(temp[l-4]);
                Node node = new Node(nodeNumber, x, y, z);
                ans.add(node);
            }
        }
        return ans;
    }
}
