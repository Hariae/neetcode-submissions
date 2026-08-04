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
    public boolean isValidBST(TreeNode root) {
        
        return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBSTUtil(TreeNode curr, int left, int right) {

        if (curr == null) return true;

        if (!(curr.val > left && curr.val < right)) return false;

        return isValidBSTUtil(curr.left, left, curr.val) && isValidBSTUtil(curr.right, curr.val, right);

    }
}
