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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;
        
        lca(root, p, q);

        return result;
        
    }

    
    
    TreeNode result = null;

    public boolean lca(TreeNode curr, TreeNode p, TreeNode q) {
        if (curr == null) return false;

        int left = lca(curr.left, p, q) ? 1 : 0;
        int right = lca(curr.right, p, q) ? 1 : 0;

        int mid = ((curr.val == p.val) || (curr.val == q.val)) ? 1 : 0 ;

        if (left + right + mid >= 2) {
            result = curr;
        }


         

       return (left + right + mid) > 0;


    }
}
