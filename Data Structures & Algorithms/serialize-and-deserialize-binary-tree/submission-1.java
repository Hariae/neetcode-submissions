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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serialzedTree = "";
        serializeUtil(root);
        System.out.println(serialzedTree);
        return serialzedTree;
        
    }
    String serialzedTree;
    public void serializeUtil(TreeNode node) {
        if (node == null) {
            serialzedTree += "N#";
            return;
        }

        serialzedTree += node.val + "#";
        serializeUtil(node.left);
        serializeUtil(node.right);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeUtil(data);
    }

    int index = 0;
    public TreeNode deserializeUtil(String data) {
        String curr = data.split("#")[index];
        if (curr.equals("N")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(curr));
        index++;
        node.left = deserializeUtil(data);
        node.right = deserializeUtil(data);
        return node;

    }
}
