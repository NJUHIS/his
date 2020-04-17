package com.njuhis.his.demo;

import com.njuhis.his.model.Department;
import com.njuhis.his.util.ResultMessage;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Paul
 * @deprecated
 */
@Data
public class DemoUser {
    private String name;
    private String password;
}



//    //TODO 待测试
//    @RequestMapping(value = "/getAllExamples")
//    public List<Example> getAllExamples(HttpServletResponse httpServletResponse) {
//        quickLogger.logInvoke();
//        List<Example> result = eggService.getAllExamples(new ResultMessage(httpServletResponse));
//        quickLogger.logReturn(result);
//        return result;
//    }
//
//    //TODO 待测试
//    @RequestMapping("/addExample")
//    public Example addExample(@RequestBody Example example, HttpServletResponse httpServletResponse){
//        quickLogger.logInvoke();
//        quickLogger.logReceive(example);
//        ResultMessage resultMessage=new ResultMessage(httpServletResponse);
//
//        Example result=eggService.addExample(example, resultMessage);
//
//        quickLogger.logReturn(result);
//        return result;
//
//    }
//
//    //TODO 待测试
//
//    @RequestMapping("/getExampleById")
//    public Example getExampleById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
//        quickLogger.logInvoke();
//        quickLogger.logReceive(id);
//        ResultMessage resultMessage=new ResultMessage(httpServletResponse);
//
//        Example result=eggService.getExampleById(id,resultMessage);
//
//        quickLogger.logReturn(result);
//        return result;
//    }
//
//
//    //TODO 待测试
//
//    @RequestMapping("/updateExample")
//    public Example updateExample(@RequestBody Example example,HttpServletResponse httpServletResponse){
//        quickLogger.logInvoke();
//        quickLogger.logReceive(example);
//        ResultMessage resultMessage=new ResultMessage(httpServletResponse);
//
//        Example result=eggService.updateExample(example, resultMessage);
//
//        quickLogger.logReturn(result);
//        return result;
//
//    }
