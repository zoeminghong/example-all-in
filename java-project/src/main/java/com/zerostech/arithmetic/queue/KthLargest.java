package com.zerostech.arithmetic.queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created on 2021/6/9.
 *
 * @author 迹_Jason
 */

public class KthLargest {

    private Queue<Integer> queue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
        kthLargest.add(6);
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}
