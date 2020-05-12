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
    private StringBuilder errorMessage=new StringBuilder();

    public ResultMessage appendErrorMessage(String errorMessage){
        this.errorMessage.append(errorMessage);
        return this;
    }

    public void sendClientError(String errorMessage) {
        this.errorMessage.append(errorMessage);
        isSuccessful = false;
        logger.log(Level.WARNING, makeYellow(this.errorMessage.toString()));
        try {
            httpServletResponse.sendError(400, this.errorMessage.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendError(String errorMessage){
        this.errorMessage.append(errorMessage);
        isSuccessful=false;
        logger.log(Level.SEVERE,makeRed(this.errorMessage.toString()));
        try{
            httpServletResponse.sendError(500,this.errorMessage.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendClientError(){
        sendClientError("");
    }
    public void sendError(){
        sendError("");
    }

    public void sendUnknownError(){
        sendError(ErrorMessage.UNKNOWN_ERROR_OCCURRED);
    }

    /**
     * 客户端錯誤
     */
    public class ErrorMessage {
        public static final String PATIENT_USERNAME_EXISTED = "The patient username has existed. 该患者用户名已存在。";
        public static final String WORKER_USERNAME_EXISTED = "The worker username has existed. 该医院员工用户名已存在。";
        public static final String REGISTRATION_NOT_EXIST = "The registration does not exist. 该挂号不存在。";
        public static final String MEDICAL_RECORD_NOT_EXIST = "The medical record does not exist. 该病历不存在。";
        public static final String INVOICE_NOT_EXIST = "The invoice does not exist. 该发票不存在。";
        public static final String USER_NOT_EXIST = "The worker user does not exist. 该医院员工用户不存在。";
        public static final String PATIENT_NOT_EXIST = "The patient user does not exist. 该患者用户不存在。";
        public static final String DEPARTMENT_NOT_EXIST = "The department does not exist. 该科室不存在。";
        public static final String EXAMINATION_TEST_DISPOSAL_NOT_EXIST = "The examination (test or disposal) does not exist. 该检查（检验或处置）不存在。";
        public static final String EXAMINATION_TEST_DISPOSAL_DETAIL_NOT_EXIST = "The examination (test or disposal) detail does not exist. 该检查（检验或处置）明细不存在。";
        public static final String PRESCRIPTION_DETAIL_NOT_EXIST = "The prescription detail does not exist. 该处方明细不存在。";
        public static final String PRESCRIPTION_NOT_EXIST = "The prescription does not exist. 该处方不存在。";
        public static final String INVOICE_DETAIL_NOT_EXIST = "The invoice detail does not exist. 该发票明细不存在。";
        public static final String CONSTANT_ITEM_NOT_EXIST = "The constant item does not exist. 该常数项不存在。";
        public static final String CONSTANT_TYPE_NOT_EXIST = "The constant type does not exist. 该常数类型不存在。";
        public static final String EXPENSE_TYPE_NOT_EXIST = "The expense type does not exist. 该费用类型不存在。";
        public static final String REGISTRATION_TYPE_NOT_EXIST = "The registration type does not exist. 该挂号类型不存在。";
        public static final String SETTLEMENT_TYPE_NOT_EXIST = "The settlement type does not exist. 该结算类型不存在。";
        public static final String SCHEDULE_NOT_EXIST="The schedule does not exist. 该排班不存在。";
        public static final String DRUG_NOT_EXIST="The drug does not exist. 该药品不存在。";
        public static final String NONDRUG_ITEM_NOT_EXIST="The non-drug item does not exist. 该非药品项目不存在。";
        public static final String INCORRECT_PASSWORD = "Incorrect password. 密码错误。";
        public static final String INVALID_FOREIGN_KEY ="Invalid foreign key. 存在无效外键。";
        public static final String NULL_VALUE ="Null Value. 存在 Null 值。";
        public static final String CANNOT_CHANGE_STATES_THROUGH_UPDATES="Cannot change states through updates. 无法通过更新来改变状态。";
        public static final String DO_NOT_CHANGE_MEDICAL_RECORD_ID="Please do not change the Medical Record ID。请不要改变病历的主键 ID。";
        public static final String DO_NOT_CHANGE_EXAMINATION_TEST_DISPOSAL_ID="Please do not change the Examination (Test or Disposal) ID。请不要改变检查（检验或处置）的主键 ID。";
        public static final String DIAGNOSIS_NOT_EXIST="The diagnosis does not exist. 该诊断不存在。";
        /**
         * 未知來源錯誤
         */
        public static final String UNKNOWN_ERROR_OCCURRED = "Unknown error occurred. 发生未知错误。";
    }

}
