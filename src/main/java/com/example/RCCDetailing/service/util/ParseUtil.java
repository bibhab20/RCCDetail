package com.example.RCCDetailing.service.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Properties;

@Slf4j
public class ParseUtil {
    private static ParseUtil instance;
    private ParseUtil(){

    }
    public static ParseUtil getInstance(){
        if(instance==null)
            instance = new ParseUtil();
        return instance;
    }
    public Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file 'application.properties' not found in the classpath");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


}