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
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        for (int i=0;i<inorder.length; i++) {
            map.put(inorder[i], i);
        }    
        return buildTreeUtil(0, preorder.length-1, preorder);       
    }

    int count = 0;
    public TreeNode buildTreeUtil(int start, int end, int[] preorder) {
        System.out.println(start + " " + end);
        if (start <= end) {    
            
            int rootVal = preorder[count];
            count++;            
            int rootPosition = map.get(rootVal);
            TreeNode node = new TreeNode(rootVal);
            
            node.left = buildTreeUtil(start, rootPosition-1, preorder);            
            node.right = buildTreeUtil(rootPosition+1, end, preorder);        
            
            return node;
        }

       return null;                
    }
}
