package com.zerostech.arithmetic.bits;

/**
 * Created on 2021/5/26.
 *
 * @author 迹_Jason
 * @link:https://leetcode-cn.com/problems/n-queens-ii
 */

public class NQueen {

    private static int count = 0;

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }

    public static int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }
        dfs(n, 0, 0, 0, 0);
        return count;
    }

    public static void dfs(int n, int row, int cols, int pie, int na) {
        if (row >= n) {
            count += 1;
            return;
        }
        // 当前所有的空位
        // (~(cols | pie | na)) 确定空位
        // ((1 << n) - 1) 用于限定位置范围
        int bits = (~(cols | pie | na)) & ((1 << n) - 1);
        while (bits > 0) {
            int p = bits & -bits; // 取到最低位的1
            dfs(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1);
            bits = bits & (bits - 1);// 去掉最低位的1
        }
    }
}
