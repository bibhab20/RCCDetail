package com.example.RCCDetailing.service.parser;

import com.example.RCCDetailing.model.AbstractStructure;
import com.example.RCCDetailing.model.Segment;
import com.example.RCCDetailing.model.Structure;

import java.util.ArrayList;
import java.util.List;

public class Parser extends AbstractParser{
    @Override
    public AbstractStructure getStructure(String text) {
        AbstractStructure structure = new Structure();
        List<String> sections = getSegmentSections(text);
        SimpleSegmentParser segmentParser = new SimpleSegmentParser();
        List<Segment> segments = new ArrayList<>();
        for(String section: sections){
            segments.add(segmentParser.parse(section));
        }
        for(Segment segment: segments){
            if(segment!=null)
                structure.addSegment(segment);
        }

        return structure;

    }

    private List<String> getSegmentSections(String text){
        StringBuilder sb = new StringBuilder();
        sb.append("==".repeat(38));
        String[] arr = text.split(sb.toString());
        return cleanUp(arr);

    }
    private List<String> cleanUp(String[] arr){
        List<String> ans = new ArrayList<>();
        for(String s: arr){
            s = s.trim();
            if(s.contains("L I M I T    S T A T E    D E S I G N")){
                ans.add(s);
            }
        }
        return ans;
    }
}
