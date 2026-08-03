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
    public int maxDepth(TreeNode root) {
        
         return maxDepth(root, 0);
    }

    public int maxDepth(TreeNode curr, int depth) {
        if (curr == null) {
            return depth;
        }

        int leftDepth = maxDepth(curr.left, depth + 1);
        int rightDepth = maxDepth(curr.right, depth +1);

        return Math.max(leftDepth, rightDepth);
    }
}
