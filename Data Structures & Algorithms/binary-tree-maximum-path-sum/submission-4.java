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
    int max= -1001; 
    public int maxPathSum(TreeNode root) {
        // postorder

        List<List<Integer>> result = levelOrder(root);
      System.out.println(result);
        maxPathSumUtil(root);
        return max;
        
    }

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

    public int maxPathSumUtil(TreeNode node) {
        if (node == null) return 0;

       // System.out.println(node.val);

        int left = Math.max(maxPathSumUtil(node.left), 0);
        int right = Math.max(maxPathSumUtil(node.right), 0);

       // int max = Math.max(Math.max(left, right), node.val);
        //int sum = Math.max(left + right + node.val, node.val);
        // int sum = left + right + node.val;
        // int double_max = (Math.max(left, right) + node.val);

      //  System.out.println(node.val + " : " + Math.max(sum, double_max));

        int curr_max = Math.max(left + right + node.val, node.val);
        
        if (curr_max > max) {
            max = curr_max;
        }

        return Math.max(left, right) + node.val;
    }
}
