package com;


/**
 * Created on 2020-02-22.
 *
 * @author 迹_Jason
 */
public class TwoTree {
    //
//    [3,9,20,15,7]
//            [9,3,15,20,7]
    public static void main(String[] args) {
        buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

    }

    public static TreeNode helper(int[] pre, int[] in, int prestart, int preend, int instart, int inend) {
        if (prestart > preend || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(pre[prestart]);
        int index = prestart;
        for (int i = instart; i <= inend; i++) {
            if (in[i] == pre[prestart]) {
                index = i;
                break;
            }
        }
        root.left = helper(pre, in, prestart + 1, prestart + index - instart, instart, index - 1);
        root.right = helper(pre, in, prestart + index - instart + 1, preend, index + 1, inend);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}