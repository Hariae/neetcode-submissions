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

-INF, +INF

, 2

 */

class Solution {
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }

    public boolean isValidBST(TreeNode curr, int min, int max) {
        if (curr == null) return true;

        if (curr.val <= min || curr.val >= max) return false;

        return isValidBST(curr.left, min, curr.val) && isValidBST(curr.right, curr.val, max);
    }
}
