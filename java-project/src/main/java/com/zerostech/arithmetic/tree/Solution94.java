package com.zerostech.arithmetic.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created on 2021/6/16.
 *
 * @author 迹_Jason
 */

public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> queue = new Stack<>();
        while (root != null || !queue.isEmpty()) {
            while (root != null) {
                queue.push(root);
                root = root.left;
            }
            TreeNode node = queue.pop();
            res.add(node.val);
            root = node.right;
        }
        return res;
    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        List<Integer> res = new ArrayList<>();
//        foreach(root, res);
//        return res;
//    }
//
//    public void foreach(TreeNode root, List<Integer> res) {
//        if(root==null){
//            return;
//        }
//        foreach(root.left, res);
//        res.add(root.val);
//        foreach(root.right, res);
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
