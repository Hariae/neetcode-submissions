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
        q.add(root);

        

        while (!q.isEmpty()) {
            Queue<TreeNode> levelQ = new LinkedList<>();
            while (!q.isEmpty()) {
                levelQ.add(q.poll());
            }
            List<Integer> levelValues = new ArrayList<>();

            while (!levelQ.isEmpty()) {
                TreeNode curr = levelQ.poll();
                levelValues.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            result.add(levelValues);

        }

        return result;

    }
}
