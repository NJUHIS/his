package com.njuhis.his.util;



import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResultMessage {
    private static final Logger logger=Logger.getLogger("ResultMessage");
    private HttpServletResponse httpServletResponse;
    public ResultMessage(HttpServletResponse httpServletResponse){
        this.httpServletResponse=httpServletResponse;
    }
    public void setError(){
        setError(UNEXPECTED_ERROR_OCCURRED);
    }
    public void setError(String errorMessage){
        logger.log(Level.WARNING,errorMessage);
        try{
            httpServletResponse.sendError(400,errorMessage);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static final String ACCOUNT_DOES_NOT_EXIST="This account does not exist.";
    private static final String UNEXPECTED_ERROR_OCCURRED="Unexpected error occurred.";
}
