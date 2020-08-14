package com.zerostech.stack.case1;

import java.util.Stack;

/**
 * Created on 2020-03-03.
 *
 * @author 迹_Jason
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 所谓字典序最小，就是字母按顺序排列。
 */
public class RemoveRepeat {

    public static String removeDuplicateLetters(String s) {
        int[] charsCount = new int[26];//计算26字母数量
        boolean[] visited = new boolean[26];//标记字母是否已经入栈
        int len = s.length();
        char[] sChars = s.toCharArray();
        // 每个字符个数
        for (char c : sChars) {
            charsCount[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        int index = 0;//结果集的长度
        for (int count : charsCount) {
            if (count > 0) index++;
        }
        char[] res = new char[index];
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            //有小字符的且满足其前面的字符在小字符后还有同样字符的，则出栈
            while (!stack.isEmpty() && c < stack.peek() && charsCount[stack.peek() - 'a'] > 1 && !visited[c - 'a']) {
                Character pop = stack.pop();
                visited[pop - 'a'] = false;
                charsCount[pop - 'a']--;
            }
            if (visited[c - 'a']) {
                charsCount[c - 'a']--;//重复的字符根据游标往后移动，数量减一
                continue;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }

        while (!stack.isEmpty()) {
            res[--index] = stack.pop();
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
