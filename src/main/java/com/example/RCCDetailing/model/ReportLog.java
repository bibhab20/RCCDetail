package com.example.RCCDetailing.model;

public class ReportLog {
    String key;
    String message;
    LogType logType;
    public ReportLog(LogType logType,String key, String message){
        this.logType = logType;
        this.message = message;
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public LogType getLogType() {
        return logType;
    }

    public String getKey() {
        return key;
    }

    public void print(){
        System.out.println(this.getLogType()+ ": "+this.getKey()+"> "+this.message);
    }
}
