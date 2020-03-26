package com.njuhis.his.util;



import lombok.Data;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.njuhis.his.util.ColorfulOutput.makeRed;
import static com.njuhis.his.util.ColorfulOutput.makeYellow;

@Data
public class ResultMessage {
    private static final Logger logger=Logger.getLogger(ResultMessage.class.getName());
    private HttpServletResponse httpServletResponse;
    public ResultMessage(HttpServletResponse httpServletResponse){
        this.httpServletResponse=httpServletResponse;
    }
    private boolean isSuccessful=true;

    public void setClientError(String errorMessage){
        isSuccessful=false;
        logger.log(Level.WARNING,makeYellow(errorMessage));
        try{
            httpServletResponse.sendError(400,errorMessage);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void setUnknownError(){
        setUnknownError(UNKNOWN_ERROR_OCCURRED);
    }
    public void setUnknownError(String errorMessage){
        isSuccessful=false;
        logger.log(Level.SEVERE,makeRed(errorMessage));
        try{
            httpServletResponse.sendError(500,errorMessage);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 客户端錯誤
     */
    public static final String PATIENT_LOGIN_NAME_EXISTED="The patient login name has existed. 患者登录名已存在。";

    /**
     * 未知來源錯誤
     */
    public static final String UNKNOWN_ERROR_OCCURRED = "Unknown error occurred. 发生未知错误。";

}
