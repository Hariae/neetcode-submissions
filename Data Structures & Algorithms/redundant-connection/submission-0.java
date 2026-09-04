class Solution {

    public boolean isConnected(int src, int dest, HashSet<Integer> visited, HashMap<Integer, List<Integer>> adjMap) {

        if (src == dest) return true;

        visited.add(src);

        for (int nei : adjMap.get(src)) {
            if (!visited.contains(nei) && isConnected(nei, dest, visited, adjMap)) {
                return true;
            }
        }

        return false;
    }


    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        HashMap<Integer, List<Integer>> adjMap = new HashMap<>();

        for (int i=1;i<=n;i++) {
            adjMap.put(i,new ArrayList<>());
        }

        for (int[] edge : edges) {
            int src = edge[0], dest = edge[1];
            
            if (isConnected(src, dest, new HashSet<>(), adjMap)) {
                return new int[]{src, dest};
            }

            adjMap.get(src).add(dest);
            adjMap.get(dest).add(src);


        }

        return new int[]{-1, -1};
        
    }
}