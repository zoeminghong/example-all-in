package com.zerostech.binarytree.case1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020-02-23.
 *
 * @author 迹_Jason
 */
public class InorderTraversal {

    // 入口
    public static List<Integer> solution(TreeNode root) {
        List list = new ArrayList();
        tree(list, root);
        return list;
    }

    public static void tree(List list, TreeNode root) {
        if (root == null) {
            return;
        }
        tree(list, root.left);
        list.add(root.val);
        tree(list, root.right);
    }

    public static void main(String[] args) {
        Integer[] treeArray = new Integer[]{1, null, 2, 3};

        System.out.println(solution(buildNode(treeArray,0)).toString());
    }

    public static TreeNode buildNode(Integer[] treeArray, int index) {
        if (index>treeArray.length-1||treeArray[index] == null) {
            return null;
        }
        TreeNode t = new TreeNode(treeArray[index]);
        t.left = buildNode(treeArray, index + 1);
        t.right = buildNode(treeArray, index + 2);
        return t;
    }
}


class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    TreeNode(Integer x) {
        val = x;
    }

    @Override
    public String toString() {
        return val+"";
    }
}