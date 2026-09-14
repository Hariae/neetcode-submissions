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

    public int diameter(TreeNode node) {
        if (node == null) return 0;

        int left = diameter(node.left);
        int right = diameter(node.right);

        int diameter = left + right;

        maxDiameter = Math.max(diameter, maxDiameter);

        return 1 + Math.max(left, right);
    }

    int maxDiameter;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = -1;
        diameter(root);
        return maxDiameter;
    }
}
