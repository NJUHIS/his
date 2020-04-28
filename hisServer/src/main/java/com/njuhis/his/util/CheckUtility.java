package com.njuhis.his.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author Paul
 */
@Component
public class CheckUtility {

    public void checkNotEmpty(Object object, Map<String,String[]> notEmptyFieldsCheckList, ResultMessage resultMessage) {
        Class objectClass = object.getClass();
        Field[] fields = objectClass.getDeclaredFields();
        StringBuilder errorMessages=new StringBuilder();
        ArrayList<String> emptyFields=new ArrayList<>();

        for (Field field : fields) {
            if ((field != null) && (!"".equals(field))) {
                //设置权限
                field.setAccessible(true);
                try {
                    Object fieldObject = field.get(object);
                    String fieldName = field.getName();

                    if (notEmptyFieldsCheckList.containsKey(fieldName)) {//如果再非空字段檢查清單中
                        if (fieldObject == null) {//如果為null
                            emptyFields.add(fieldName);
                            //
                        }else if (fieldObject instanceof String) {//如果為 String
                            if ("".equals(((String) fieldObject).trim())) {//如果 String 為空
                                emptyFields.add(fieldName);
                            }
                        }
                    }
                }catch (Exception exception){
                    exception.printStackTrace();
                    resultMessage.sendUnknownError();
                    return;
                }

            }

        }
        if(!emptyFields.isEmpty()){
            for(String fieldName:emptyFields){
                errorMessages.append("\nThe \""+notEmptyFieldsCheckList.get(fieldName)[0]+" ("+fieldName+")\" cannot be left empty. 「"+notEmptyFieldsCheckList.get(fieldName)[1]+"」不能为空。");
            }
            resultMessage.sendClientError(errorMessages.toString());
        }

    }


//    /**
//     * 判断一个对象中的某些字段是否为空
//     *
//     * @param object 传入一个对象
//     * @param map key为传入需要判断的是否为空的字段，value为传入需要提示的错误信息
//     * @return 当判断出有为空的字段时，会返回错误信息，当传入的字段都不为空时，返回null
//     * @throws IllegalAccessException
//     * @deprecated
//     */
//    public static String checkNotNullOrEmpty(Object object, Map<String, String> map) throws IllegalAccessException {
//        Class objectClass = object.getClass();
//        Field[] fields = objectClass.getDeclaredFields();
//        for (Field field : fields) {
//            if ((field != null) && (!"".equals(field))) {
//                //设置权限
//                field.setAccessible(true);
//                Object fieldObject = field.get(object);
//                String fieldName = field.getName();
//                if (map.containsKey(fieldName)) {
//                    if (fieldObject == null) {
//                        return map.get(fieldName);
//                    }
//                    if (fieldObject instanceof String) {
//                        if (fieldObject == null || "".equals(((String) fieldObject).trim())) {
//                            return map.get(fieldName);
//                        }
//                    }
//                }
//            }
//        }
//        return null;
//    }


}
