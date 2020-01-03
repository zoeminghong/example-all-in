package com;

/**
 * Created on 2019-12-27.
 * 选择排序（Selection Sort）
 * @author 迹_Jason
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 3, 2, 1};
        int index = 0;

        for (int j = 0; j < array.length - 1; j++) {
            for (int i = j; i < array.length - 1; i++) {
                index = i;
                // 这一步是关键
                if (array[index] > array[i + 1]) {
                    index = i + 1;
                }
            }
            int old = array[j];
            array[j] = array[index];
            array[index] = old;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

}
