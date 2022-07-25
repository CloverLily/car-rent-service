package com.lily.demo.rental.common.util;

import org.apache.logging.log4j.util.Strings;
import org.joda.time.DateTime;

import java.util.*;

/**
 * 日期转换工具
 *
 * @author lily
 * @date 2022/7/25
 */
public class DateUtil {

    private DateUtil() {
    }

    /**
     * 日期格式-年月日时分秒毫秒 yyyyMMddHHmmssSSS
     */
    public static final String DATE_PATTERN_Y4M2D2H2M2S2S3 = "yyyyMMddHHmmssSSS";

    /**
     * yyyyMMddHHmmssSSS
     *
     * @param date 日期
     * @return 处理后的结果
     */
    public static String dateToString(Date date, String pattern) {
        if (Strings.isBlank(pattern)) {
            return null;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(pattern);
    }

}
