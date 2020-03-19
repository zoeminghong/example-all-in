package com.zerostech.stock.broadcast.utils;

/**
 * Created on 2020-03-19.
 *
 * @author 迹_Jason
 */
public class StringUtils {

    public static String patternText(String source, Object... arg) {
        for (Object s : arg) {
            source = source.replaceFirst("\\{\\}", s.toString());
        }
        return source;
    }
}
