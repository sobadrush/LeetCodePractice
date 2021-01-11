package org.leetcode.easy.tree;

/*
    Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
    For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

            1
           / \
          2   2
         / \ / \
        3  4 4  3

              1
            /  \
          2      2
         / \    / \
        3  4    4  3
       / \ /\  /\  /\
      5  6 7 8 8 7 6 5

    But the following [1,2,2,null,3,null,3] is not:

            1
           / \
          2   2
           \   \
           3    3
 */


import java.util.ArrayList;
import java.util.List;

public class Leetcode_101 {


    private static boolean helper(TreeNode nodeLeft, TreeNode nodeRight) {

        if (nodeLeft == null && nodeRight == null) {
            return true;
        }

        if (nodeLeft == null || nodeRight == null) {
            return false;
        }

        if (nodeLeft.val != nodeRight.val) {
            return false;
        }
        return helper(nodeLeft.left, nodeLeft.right) && helper(nodeRight.left, nodeRight.right);
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    public static void main(String[] args) {
        // 1,2,2,3,4,4,3
        // TreeNode node1 = new TreeNode(1);
        // TreeNode node2 = new TreeNode(2);
        // TreeNode node3 = new TreeNode(2);
        // TreeNode node4 = new TreeNode(3);
        // TreeNode node5 = new TreeNode(4);
        // TreeNode node6 = new TreeNode(4);
        // TreeNode node7 = new TreeNode(3);

         /*
                1
               / \
              2   2
               \   \
               3    3
         */

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = null;
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = null;
        TreeNode node7 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        System.out.println("ans = " + isSymmetric(node1));
    }
}
