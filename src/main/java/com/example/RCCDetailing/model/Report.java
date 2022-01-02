package com.example.RCCDetailing.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report {
    List<ReportLog> logs;
    Map<String , List<ReportLog>> keyMap;
    Map<LogType, List<ReportLog>> typeMap;
    public  Report(){
        this.logs = new ArrayList<>();
        this.keyMap = new HashMap<>();
        this.typeMap = new HashMap<>();
    }
    public void addLog(ReportLog log){
        this.logs.add(log);
        List<ReportLog> keyLogs = keyMap.get(log.getKey());
        if(keyLogs == null){
            keyLogs = new ArrayList<>();
            keyMap.put(log.getKey(),keyLogs);
        }
        keyLogs.add(log);
        List<ReportLog> typeLogs = typeMap.get(log.getLogType());
        if(typeLogs == null){
            typeLogs = new ArrayList<>();
            typeMap.put(log.logType,typeLogs);
        }
        typeLogs.add(log);

    }
    public void addLogs(List<ReportLog> logs){
        for(ReportLog log: logs){
            this.addLog(log);
        }
    }

    public void printLogs(String key){
        if(!keyMap.containsKey(key))
            return;
        for(ReportLog log: this.keyMap.get(key)){
            log.print();
        }
    }
    public void printLogs(LogType logType){
        if(!typeMap.containsKey(logType))
            return;
        for (ReportLog log: logs){
            log.print();
        }
    }
    public void printAllLogs(){
        for (ReportLog log: logs){
            log.print();
        }
    }
}
