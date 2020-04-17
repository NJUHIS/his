package com.njuhis.his.demo;

import com.njuhis.his.util.ResultMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Paul
 * @deprecated
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/printUserWithRequestBody")
    public void printUserWithRequestBody(@RequestBody DemoUser demoUser){

    }

    @RequestMapping("/printUserWithRequestParam")
    public void printUserWithRequestParam(@RequestParam String name, String password){
        System.out.println(name+" "+password);
    }

    @RequestMapping("/printUserWithPathVariable/{name}/{password}")
    public void printUserWithPathVariable(@PathVariable String name, @PathVariable String password){
        System.out.println(name+" "+password);
    }

}

//    //TODO 待测试
//    public List<Example> getAllExamples(ResultMessage resultMessage){
//        return exampleMapper.selectAll();
//    }
//
//    //TODO 待测试
//    public Example addExample(Example example,ResultMessage resultMessage){
//        try {
//            exampleMapper.insert(example);
//            return example;
//        } catch (Exception exception) {
//            exception.printStackTrace();
//            resultMessage.setUnknownError();
//            return null;
//        }
//    }
//
//    //TODO 待测试
//    public Example getExampleById(Integer id, ResultMessage resultMessage){
//        Example example=exampleMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
//        if(example!=null){
//            return example;
//        }else{
//            resultMessage.setClientError(ResultMessage.ErrorMessage.EXAMPLE_NOT_EXIST);
//            return null;
//        }
//
//    }
//
//    //TODO 待测试
//    public Example updateExample(Example example, ResultMessage resultMessage){
//        getExampleById(example.getId(),resultMessage);
//        if(resultMessage.isSuccessful()) {//如果 id 存在
//            try {
//                exampleMapper.updateByPrimaryKey(example);
//                return getExampleById(example.getId(),resultMessage);
//            } catch (Exception exception) {
//                exception.printStackTrace();
//                resultMessage.setUnknownError();
//                return null;
//            }
//        }else{
//            return null;
//        }
//    }
//
//
//
//