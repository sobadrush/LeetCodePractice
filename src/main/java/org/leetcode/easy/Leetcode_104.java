package org.leetcode.easy;

/*
    104. Maximum Depth of Binary Tree
 */
/*
    Given the root of a binary tree, return its maximum depth.
    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
/*
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


    Constraints:
        The number of nodes in the tree is in the range [0, 10^4].
        -100 <= Node.val <= 100
 */
public class Leetcode_104 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
            3
           / \
          9  20
             / \
            15  7
     */

    private static int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        // root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        TreeNode td1 = new TreeNode(9);
        TreeNode td2 = new TreeNode(20);
        TreeNode td3 = null;
        TreeNode td4 = null;
        TreeNode td5 = new TreeNode(15);
        TreeNode td6 = new TreeNode(7);

        root.left = td1;
        root.right = td2;
        td1.left = td3;
        td1.right = td4;
        td2.left = td5;
        td2.right = td6;

        System.out.println("Max Depth = " + maxDepth(root));
    }
}
