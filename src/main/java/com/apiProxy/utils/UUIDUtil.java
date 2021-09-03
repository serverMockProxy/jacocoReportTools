package com.apiProxy.utils;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
public class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    public static long getTimeStamp(){
        return new Date().getTime();
    }

    public static String getUUIDFilename(String filename) {
        Assert.hasText(filename, "filename不能为空");
        return filename.contains(".") ? getTimeStamp() + "." + StringUtils.unqualify(filename) : String.valueOf(getTimeStamp());
    }
}
