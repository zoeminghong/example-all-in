package com.zerostech.arithmetic.dongtai;

/**
 * Created on 2021/5/27.
 *
 * @author 迹_Jason
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */

public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;

        for (int i = 2; i < n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n - 1];
    }
}
