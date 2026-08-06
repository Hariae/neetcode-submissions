/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Node clone = new Node(node.val);
        visited.put(clone.val, clone);
        List<Node> cloneNeighbors = clone.neighbors;

        for (Node neighbor : node.neighbors) {
            if (!visited.containsKey(neighbor.val)) {
                Node clonedNeighbor = cloneGraph(neighbor);
                if (clonedNeighbor != null) {
                    cloneNeighbors.add(clonedNeighbor);
                }
            } else {
                cloneNeighbors.add(visited.get(neighbor.val));
            }

                        
        }

        return clone;
    }

    
}