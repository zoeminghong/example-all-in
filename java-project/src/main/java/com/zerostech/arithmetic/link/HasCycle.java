package com.zerostech.arithmetic.link;

import java.util.*;

/**
 * Created on 2021/6/2.
 *
 * @author 迹_Jason
 */

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> nodeList = new HashSet<>();
        ListNode current = head;
        do {
            if (nodeList.contains(current.next)) {
                return true;
            }
            nodeList.add(current);
            current = current.next;
        } while (current != null);
        return false;
    }

//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> seen = new HashSet<ListNode>();
//        while (head != null) {
//            if (!seen.add(head)) {
//                return true;
//            }
//            head = head.next;
//        }
//        return false;
//    }
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
