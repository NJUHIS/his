package com.njuhis.his.util;

/**
 * @author Paul
 */
public class ColorfulOutput {
    public static final String PURPLE_RED="\033[0;35m";
    public static final String DEFAULT="\033[0m";
    public static final String BLUE="\033[0;34m";
    public static String makePurpleRed(String input){
        return PURPLE_RED+input+DEFAULT;
    }
    public static String makeBlue(String input){
        return BLUE+input+DEFAULT;
    }
}

/**
 * \033[显示方式;字体颜色;背景颜色m 中间是变颜色的内容 \033[0m
 *
 * 字体色            背景色           颜色
 * ---------------------------------------
 * 30                40              黑色
 * 31                41              红色
 * 32                42              绿色
 * 33                43              黃色
 * 34                44              蓝色
 * 35                45              紫红色
 * 36                46              青蓝色
 * 37                47              白色
 *
 * 显示方式           意义
 * -------------------------
 * 0                终端默认设置
 * 1                高亮显示
 * 4                使用下划线
 * 5                闪烁
 * 7                反白显示
 * 8                不可见
 */