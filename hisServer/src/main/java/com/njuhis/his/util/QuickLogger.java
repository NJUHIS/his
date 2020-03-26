package com.njuhis.his.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class QuickLogger {
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
    public void logInvoked(){
        log("Invoked",3);
    }
    public void logReturn(String message){
        log("Returns "+message,3);
    }
}
