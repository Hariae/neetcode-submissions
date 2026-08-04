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
        
        String serialzedTree = serializeUtil(root, "");
        //System.out.println(serialzedTree);
        return serialzedTree;
        
    }
    
    public String serializeUtil(TreeNode node, String serialzedTree) {
        if (node == null) {
            serialzedTree += "N#";
            return serialzedTree;
        }

        serialzedTree += node.val + "#";
        serialzedTree = serializeUtil(node.left, serialzedTree);
        serialzedTree = serializeUtil(node.right, serialzedTree);
        return serialzedTree;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataParts = data.split("#");
        List<String> dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(dataParts));
        return deserializeUtil(data, dataList);
    }

    public TreeNode deserializeUtil(String data, List<String> dataList) {
        String curr = dataList.get(0);
        dataList.remove(0);
        if (curr.equals("N")) {            
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(curr));
        node.left = deserializeUtil(data, dataList);
        node.right = deserializeUtil(data, dataList);
        return node;

    }
}
