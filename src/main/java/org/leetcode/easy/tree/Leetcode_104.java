package org.leetcode.easy.tree;

/*
    104. Maximum Depth of Binary Tree
    Easy

    Given the root of a binary tree, return its maximum depth.
    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: 3


    Example 2:
    Input: root = [1,null,2]
    Output: 2

    Example 3:
    Input: root = []
    Output: 0

    Example 4:
    Input: root = [0]
    Output: 1
 */

public class Leetcode_104 {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = null;
        TreeNode node5 = null;
        TreeNode node6 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        System.out.println("ans = " + maxDepth(node1));
    }
}
