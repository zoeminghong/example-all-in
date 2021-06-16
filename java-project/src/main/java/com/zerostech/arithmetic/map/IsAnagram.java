package com.zerostech.arithmetic.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2021/6/9.
 *
 * @author 迹_Jason
 */

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);

    }
}
