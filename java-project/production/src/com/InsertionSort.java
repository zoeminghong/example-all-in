package com;

/**
 * Created on 2019-12-27.
 *
 * @author 迹_Jason
 */
public class InsertionSort {
    //    对一组数据 4，5，6，3，2，1，从小到大进行排序
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 3, 2, 1};
        for (int i = 1; i < array.length; i++) {
            int v = array[i];
            int j = i - 1;
            for (; j > 0; j--) {
                if (array[j] > v) {
                    array[j+1]=array[j];
                }else{
                    break;
                }
            }
            array[j+1] = v;
        }


    }

}
