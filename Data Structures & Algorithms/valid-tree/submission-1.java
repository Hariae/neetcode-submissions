class Solution {
    public boolean validTree(int n, int[][] edges) {

        HashMap<Integer, List<Integer>> adjMap = new HashMap<>();


        for (int i=0;i<n;i++) {
            adjMap.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjMap.get(edge[0]).add(edge[1]);            
            adjMap.get(edge[1]).add(edge[0]);            
        }

        HashSet<Integer> visited = new HashSet<>();
        if (!dfs(0, -1, adjMap, visited)) return false;
        System.out.println(visited);

        return visited.size() == n;

    }

    public boolean dfs(int node, int parent, HashMap<Integer, List<Integer>> adjMap, HashSet<Integer> visited) {

        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        for (int nei : adjMap.get(node)) {
            if (nei == parent) continue;

            if (!dfs(nei, node, adjMap, visited)) {
                return false;
            }
        }

        return true;
    }
}
