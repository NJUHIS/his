package com.njuhis.his.service;

import com.njuhis.his.mapper.DiseaseMapper;
import com.njuhis.his.mapper.FmedItemMapper;
import com.njuhis.his.model.Disease;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilityService {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());

    /**
     * 处理数据库提示的无效外键和不合法的空值的问题
     * //TODO 记得确保所有的有必要的 add 和 update 类的方法加上这个处理。
     * //TODO 记得将数据库中所有的永远都不能为 null 的字段 加上 NOT NULL。
     * //TODO 记得给数据库中 Unique 的字段加上 UNIQUE，尤其是两个用户名。
     * //TODO 记得给一些 state 加上默认值。
     * @param resultMessage
     * @param exception
     */
    public void dealDataIntegrityViolationException(ResultMessage resultMessage, DataIntegrityViolationException exception) {
        exception.printStackTrace();
        String sentenceOfCause = exception.getCause().toString();
        if (sentenceOfCause.contains("a foreign key constraint fails")) {
            resultMessage.appendErrorMessage(ResultMessage.ErrorMessage.INVALID_FOREIGN_KEY);
            String foreignKey = sentenceOfCause.substring(sentenceOfCause.indexOf("FOREIGN KEY") + 14, sentenceOfCause.indexOf("REFERENCES") - 3);
            resultMessage.appendErrorMessage("Please check " + foreignKey + ". 请检查 " + foreignKey + "。");
            resultMessage.sendClientError();
        } else if (sentenceOfCause.contains("cannot be null")){
            resultMessage.appendErrorMessage(ResultMessage.ErrorMessage.NULL_VALUE);
            String nullValue = sentenceOfCause.substring(sentenceOfCause.indexOf("Column") + 8, sentenceOfCause.indexOf("cannot be null") - 2);
            resultMessage.appendErrorMessage("Please check " + nullValue + ". 请检查 " + nullValue + "。");
            resultMessage.sendClientError();
        }else{
            resultMessage.sendUnknownError();
        }
    }


    @Autowired
    FmedItemMapper fmedItemMapper;
    @Autowired
    UtilityService utilityService;
    @Autowired
    DiseaseMapper diseaseMapper;


    public List<Disease> getAllDiagnoses(ResultMessage resultMessage){
        return diseaseMapper.selectAll();
    }


    public Disease addDisease(Disease disease,ResultMessage resultMessage){
        try {
            diseaseMapper.insert(disease);
        }catch (DataIntegrityViolationException exception) {
            utilityService.dealDataIntegrityViolationException(resultMessage, exception);
            return null;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.sendUnknownError();
            return null;
        }
        return getDiseaseById(disease.getId(),resultMessage);
    }


    public Disease getDiseaseById(Integer id, ResultMessage resultMessage){
        Disease disease=diseaseMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(disease!=null){
            return disease;
        }else{
            resultMessage.sendClientError(ResultMessage.ErrorMessage.DIAGNOSIS_NOT_EXIST);
            return null;
        }
    }


    public Disease updateDisease(Disease disease, ResultMessage resultMessage){
        getDiseaseById(disease.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                diseaseMapper.updateByPrimaryKey(disease);
                return getDiseaseById(disease.getId(),resultMessage);
            }catch (DataIntegrityViolationException exception) {
                utilityService.dealDataIntegrityViolationException(resultMessage, exception);
                return null;
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.sendUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }


    
    
    
    
    

}
