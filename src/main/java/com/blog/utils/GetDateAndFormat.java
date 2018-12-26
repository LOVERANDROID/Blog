package com.blog.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDateAndFormat {
    /**
     * format:yyyy-MM-dd HH:mm:ss(hh:表示12小时格式)
     * @return 返回yyyy-MM-dd HH:mm:ss格式的日期字符串
     */
    public static String getDate() {
        Date date = null;
        date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date.getTime());
    }

    /**
     * format:yyyyMMddhhmmss
     * @return 返回yyyyMMddhhmmss形式的日期字符串，主要用于命名
     */
    public static String getTimeWithSimpleFormat() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(new Date().getTime());
    }

    /**
     * 显示自定义的时间格式
     * @param format 自定义的格式
     * @param date 需要格式化的时间
     * @return 返回指定日期格式的字符串
     */
    public static String getTimeWithCustomFormat(String format, Date date) {
        SimpleDateFormat ft = new SimpleDateFormat(format);
        return ft.format(date.getTime());
    }

}
