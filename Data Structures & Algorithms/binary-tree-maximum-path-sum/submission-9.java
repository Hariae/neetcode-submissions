/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        gainFromSubtree(root);
        return max;
    }

    public int gainFromSubtree(TreeNode root)  {
        if (root == null) return 0;

        int gainFromLeft = Math.max(gainFromSubtree(root.left), 0);
        int gainFromRight = Math.max(gainFromSubtree(root.right), 0);

        

        max = Math.max(max,root.val + gainFromLeft + gainFromRight);

        return Math.max(root.val +gainFromLeft, root.val +  gainFromRight);
    }
}
