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
    public boolean isBalanced(TreeNode root) {

        result = true;
        isBalanced(root, 0);
        return result;
    }

    boolean result;

    public int isBalanced(TreeNode node, int height) {
        if (node == null) return height;

        height++;
        
        int left = isBalanced(node.left, height);
        int right = isBalanced(node.right, height);

        if (Math.abs(left-right) > 1) {
            result = false;
        }

       // System.out.println(node.val + 
       // " " + left + " " + right + " " + result );

        return Math.max(left, right);
    }
}
