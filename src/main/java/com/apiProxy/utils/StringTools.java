package com.apiProxy.utils;

import org.springframework.util.StringUtils;

/**
 * @Author：hem
 * @Date：6/25/21 6:37 下午
 */
public class StringTools {

    public static String substringAfter(String str, String separator) {
        if (StringUtils.isEmpty(str)) {
            return str;
        } else if (separator == null) {
            return "";
        } else {
            int pos = str.indexOf(separator);
            return pos == -1 ? "" : str.substring(pos + separator.length());
        }
    }

    public static String substringBefore(String str, String separator) {
        if (!StringUtils.isEmpty(str) && separator != null) {
            if (separator.length() == 0) {
                return "";
            } else {
                int pos = str.indexOf(separator);
                return pos == -1 ? str : str.substring(0, pos);
            }
        } else {
            return str;
        }
    }
}
