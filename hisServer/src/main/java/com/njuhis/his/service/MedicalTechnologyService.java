package com.njuhis.his.service;

import com.njuhis.his.model.CheckApply;
import com.njuhis.his.model.CheckDetailed;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalTechnologyService {
    private QuickLogger quickLogger = new QuickLogger(this.getClass());
    @Autowired
    private DoctorService doctorService;


    public CheckDetailed startCheckDetailed(Integer checkDetailedId, ResultMessage resultMessage) {
        CheckDetailed checkDetailed = doctorService.getCheckDetailedById(checkDetailedId, resultMessage);
        if (!resultMessage.isSuccessful()) return null;

        //TODO 检查CheckDetailed状态初始值
        //TODO 检查CheckApply状态
        if(checkDetailed.getState()!=1){//如果不是 1 - 未检验检查处置
            resultMessage.sendClientError("The state is not 1. 状态不是 1 - 未检验检查处置");
            return null;
        }
        CheckApply checkApply = doctorService.getCheckApplyById(checkDetailed.getCheckappid(), resultMessage);if (!resultMessage.isSuccessful()) return null;
        checkApply.setState(4);//4 - 正在检验检查处置或等待结果
        checkDetailed.setState(2);// 2 - 检验检查处置中

        doctorService.updateCheckApplyInternal(checkApply,resultMessage);if(!resultMessage.isSuccessful())return null;
        checkDetailed = doctorService.updateCheckDetailedInternal(checkDetailed, resultMessage);
        if (!resultMessage.isSuccessful()) return null;
        return checkDetailed;
    }

    public CheckDetailed finishCheckDetailed(Integer checkDetailedId, ResultMessage resultMessage) {
        CheckDetailed checkDetailed = doctorService.getCheckDetailedById(checkDetailedId, resultMessage);
        if (!resultMessage.isSuccessful()) return null;

        //TODO 检查状态初始值
        //TODO 检查CheckApply状态

        if(checkDetailed.getState()!=2){//如果不是 2 - 检验检查处置中
            resultMessage.sendClientError("The state is not 2. 状态不是 2 - 检验检查处置中");
            return null;
        }

        checkDetailed.setState(3);// 3 - 检验检查处置完成，结果未出

        checkDetailed = doctorService.updateCheckDetailedInternal(checkDetailed, resultMessage);
        if (!resultMessage.isSuccessful()) return null;
        return checkDetailed;
    }

    public CheckDetailed reportCheckDetailed(Integer checkDetailedId, ResultMessage resultMessage) {
        CheckDetailed checkDetailed = doctorService.getCheckDetailedById(checkDetailedId, resultMessage);
        if (!resultMessage.isSuccessful()) return null;

        //TODO 检查状态初始值
        //TODO 检查CheckApply状态
        if(checkDetailed.getState()!=3){//如果不是 3 - 检验检查处置完成，结果未出
            resultMessage.sendClientError("The state is not 3. 状态不是 3 - 检验检查处置完成，结果未出");
            return null;
        }

        checkDetailed.setState(3);// 3 - 检验检查处置完成，结果未出


        checkDetailed.setState(4);// 4 - 结果已出
        checkDetailed = doctorService.updateCheckDetailedInternal(checkDetailed, resultMessage);if (!resultMessage.isSuccessful()) return null;

        reportCheckApply(checkDetailed.getCheckappid(),resultMessage);if(!resultMessage.isSuccessful())return null;

        return checkDetailed;
    }

    /**
     * 检查该 CheckApply 下面所有的 CheckDetailed 是否全部都是结果已出。如果是，则将CheckApply的状态设为 "5 - 检验检查处置已完成，结果已出"
     */
    private void reportCheckApply(Integer checkApplyId, ResultMessage resultMessage) {
        CheckApply checkApply = doctorService.getCheckApplyById(checkApplyId, resultMessage);if(!resultMessage.isSuccessful())return;

        //TODO 检查状态初始值

        boolean allReported=true;
        for (CheckDetailed checkDetailed :checkApply.getCheckDetailedList()) {
            if(!checkDetailed.getState().equals(4)) {// 4 - 结果已出
                allReported=false;
                break;
            }
        }
        if(allReported){
            checkApply.setState(5);//5 - 检验检查处置已完成，结果已出
            doctorService.updateCheckApplyInternal(checkApply,resultMessage);if(!resultMessage.isSuccessful())return;
        }
    }





}
