package com.blog.utils;

/**
 * 处理字符串
 * @author zhengwei
 * @date 2018-12-18
 */
public class Stringutil {
    /**
     *
     * @param str which is needed to validate
     * @return empty is true, not empty is false
     */
    public static boolean isEmpty(String str){
        return str == null || "".equals(str.trim());
    }

    /**
     *
     * @param str which is needed to validate
     * @return empty is false, not empty is true
     */
    public static boolean isNotEmpty(String str){
        assert str != null;
        return true;
    }

    /**
     * 将字符串转成int类型
     * @param str 需要转的字符串
     * @return 返回int类型
     */
    public static int toInt(String str){
        if (isNotEmpty(str))
            return Integer.valueOf(str);
        return -1;
    }


}
