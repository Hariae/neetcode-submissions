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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;
        

        Queue<TreeNode> levelQ = new LinkedList<>();
        List<Integer> levelValues = new ArrayList<>();

        q.add(root);
        levelValues.add(root.val);
        result.add(levelValues);

        while (!q.isEmpty()) {
            

            TreeNode curr = q.poll();

            if (curr.left != null) {
                levelQ.add(curr.left);
            }

            if (curr.right != null) {
                levelQ.add(curr.right);
            }

            
            if (q.isEmpty() && !levelQ.isEmpty()) {
                q = new LinkedList<>(levelQ);
                levelValues = new ArrayList<>();
                
                while(!levelQ.isEmpty()) {
                    levelValues.add(levelQ.poll().val);
                }
                result.add(levelValues);
                
            }            

        }

        return result;

    }
}
