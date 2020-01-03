package com;

/**
 * Created on 2019-12-27.
 * 冒泡排序
 *
 * @author 迹_Jason
 */
public class BubbleSort {
    //    对一组数据 4，5，6，3，2，1，从小到大进行排序
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 3, 2, 1};
        boolean flag = false;
        for (int j = 0; j < array.length - 1; j++) {
            for (int i = 0; i < array.length - j - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int v = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = v;
                    flag = true; // 表示有数据交换
                }
            }
            if (!flag) break;
        }


        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
