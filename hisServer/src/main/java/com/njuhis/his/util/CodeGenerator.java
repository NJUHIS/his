package com.njuhis.his.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/11/26.
 */
public class CodeGenerator {
    public static String createId(){
        String s = UUID.randomUUID().toString();
        s = s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhssmm");
        String time = simpleDateFormat.format(date);
        return time+s.substring(0, 10);
    }

    public static void main(String[] args){
        String code = CodeGenerator.createId();
        System.out.println(code);
    }



}
