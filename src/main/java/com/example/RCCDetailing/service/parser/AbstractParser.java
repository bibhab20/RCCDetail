package com.example.RCCDetailing.service.parser;

import com.example.RCCDetailing.model.AbstractStructure;

public abstract class AbstractParser {
    public abstract AbstractStructure getStructure(String text);
}
