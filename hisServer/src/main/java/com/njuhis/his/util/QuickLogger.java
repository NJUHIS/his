package com.njuhis.his.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Paul
 */
public class QuickLogger {
    //public static Gson gson=new Gson();
    public static Gson gson = new Gson().newBuilder().serializeNulls().create();
    //後面一串東西的作用是使gson轉換值為null的變量。
    // 默認情況下gson是不轉換值為null的變量的。

    public Logger logger;
    ObjectMapper objectMapper = new ObjectMapper(); //这是Jackson
    private String colorfulClassName;

    public QuickLogger(Class paramClass) {
        this.logger = Logger.getLogger(paramClass.getName());
        colorfulClassName = ColorfulOutput.makePurpleRed(paramClass.getSimpleName());
    }

    //一级
    private void log(String message, int traceIndex) {
        String methodName = Thread.currentThread().getStackTrace()[traceIndex].getMethodName();
        String colorfulClassMethodName = colorfulClassName + " " + ColorfulOutput.makeBlue(methodName) + ": ";
        logger.log(Level.INFO, colorfulClassMethodName + message);
    }

    //二级
    public void log(String message) {
        log(message, 3);

    }

    public void log() {
        log("",3);
    }

    public void log(Object object) {
        try {
            log(objectMapper.writeValueAsString(object),3);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void logInvoked() {
        System.out.println("--------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log("Invoked",3);

    }

    public void logReceive(Object object) {
        try {
            log("Received " + objectMapper.writeValueAsString(object),3);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void logReturn(Object object) {
        try {
            log("Returned " + objectMapper.writeValueAsString(object),3);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<---------------------------------");
    }
}
