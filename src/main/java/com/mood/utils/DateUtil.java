package com.mood.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public final static String LONGDATEFORMATER = "yyyy-MM-dd HH:mm:ss";

    /**
     * 把时间装成指定的字符串
     *
     * @param datePattern
     *            转换格式
     * @param date
     *            日期
     * @return 时间字符串
     */
    public static final String convertDateToString(String datePattern, Date date) {
        String returnValue = null;
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(datePattern);
            returnValue = df.format(date);
        }
        return (returnValue);
    }

    /**
     * 把时间装成指定的字符串 (yyyy-MM-dd HH:mm:ss)
     *
     * @param date
     *            日期
     * @return 时间字符串
     */
    public static final String convertDateToString(Date date) {
        return convertDateToString(LONGDATEFORMATER, date);
    }
}
