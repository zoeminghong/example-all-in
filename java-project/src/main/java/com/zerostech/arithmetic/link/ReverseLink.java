package com.zerostech.arithmetic.link;

import java.util.Stack;

/**
 * Created on 2021/6/2.
 * @link https://leetcode-cn.com/problems/reverse-linked-list/
 * @author 迹_Jason
 */

public class ReverseLink {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        reverseList(head);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        Stack<Integer> stack = new Stack<>();
        do {
            stack.push(current.val);
            // 这步不能忘记
            current = current.next;
        } while (current != null);

        ListNode reverse = null;
        while (!stack.isEmpty()) {
            Integer currentVal = stack.pop();
            if (reverse == null) {
                reverse = new ListNode(currentVal);
                current = reverse;
            } else {
                current.next = new ListNode(currentVal);
                // 这步不能忘记
                current = current.next;
            }
        }
        return reverse;
    }

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
