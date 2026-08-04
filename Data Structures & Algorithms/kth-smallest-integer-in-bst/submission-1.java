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
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestUtil(root, k, 0);
        return result;

    }

    int result = -1;

    public int kthSmallestUtil(TreeNode node, int k, int index) {
        
        if (node == null) return 0;

        int left = kthSmallestUtil(node.left, k, index);
        index++;
        if (left + index == k) {
            result = node.val;
        }
        System.out.println(node.val + " : " + (left + index));
        int right = kthSmallestUtil(node.right, k, left + index);

        return left + right + 1;
    }
}
