package com.njuhis.his.util;

import com.google.gson.Gson;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Paul
 *
 */
public class QuickLogger {
    public static Gson gson=new Gson();
    public Logger logger;
    private String colorfulClassName;
    public QuickLogger(Class paramClass){
        this.logger=Logger.getLogger(paramClass.getName());
        colorfulClassName= ColorfulOutput.makePurpleRed(paramClass.getSimpleName());
    }
    private void log(String message, int traceIndex){
        String methodName=Thread.currentThread().getStackTrace()[traceIndex].getMethodName();
        String colorfulClassMethodName=colorfulClassName+" "+ColorfulOutput.makeBlue(methodName)+": ";
        logger.log(Level.INFO,colorfulClassMethodName+message);
    }
    public void log(String message){
        log(message,3);
    }
    public void log(){
        log("",3);
    }
    public void log(Object obj){
        log(gson.toJson(obj),3);
    }
    public void logInvoked(){
        log("Invoked",3);
    }
    public void logReceive(Object obj){
        log("Received "+gson.toJson(obj),3);
    }
    public void logReturn(Object obj){
        log("Returned "+gson.toJson(obj),3);
    }
}
