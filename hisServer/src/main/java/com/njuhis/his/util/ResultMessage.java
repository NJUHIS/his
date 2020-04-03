package com.njuhis.his.util;



import lombok.Data;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.njuhis.his.util.ColorfulOutput.makeRed;
import static com.njuhis.his.util.ColorfulOutput.makeYellow;

/**
 * @author Paul
 * 此類用以設置與發送錯誤信息。
 */
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
    public static final String PATIENT_LOGIN_NAME_EXISTED="The patient login name has existed. 该患者登录名已存在。";
    public static final String REGISTRATION_NOT_EXIST="The registration does not exist. 该挂号不存在。";
    public static final String MEDICAL_CARD_NOT_EXIST="The medical record does not exist. 该病历不存在。";
    public static final String INVOICE_NOT_EXIST="The invoice does not exist. 该发票不存在。";
    public static final String USER_NOT_EXIST="The worker user does not exist. 该医院员工用户不存在。";
    public static final String DEPARTMENT_NOT_EXIST="The department does not exist. 该科室不存在。";
    public static final String EXAMINATION_TEST_DISPOSAL_NOT_EXIST="The examination (test or disposal) does not exist. 该检查（检验或处置）不存在。";
    /**
     * 未知來源錯誤
     */
    public static final String UNKNOWN_ERROR_OCCURRED = "Unknown error occurred. 发生未知错误。";

}
