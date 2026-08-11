class DSU {
    int[] parent;
    int[] size;
    int components;

    DSU(int n) {
        this.parent = new int[n + 1];
        this.size = new int[n + 1];
        this.components = n;

        for (int i=0;i<parent.length;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int components() {
        return components;
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false;

        if (size[px] > size[py]) {
            parent[py] = px;
            size[px] += size[py];
        } else {
            parent[px] = py;
            size[py] += size[px];
        }
        components--;
        return true;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

       

       return parent[x];
    }
}

class Solution {
    // public boolean validTree(int n, int[][] edges) {

        

    //     HashMap<Integer, List<Integer>> adjMap = new HashMap<>();


    //     for (int i=0;i<n;i++) {
    //         adjMap.put(i, new ArrayList<>());
    //     }

    //     for (int[] edge : edges) {
    //         adjMap.get(edge[0]).add(edge[1]);            
    //         adjMap.get(edge[1]).add(edge[0]);            
    //     }

    //     HashSet<Integer> visited = new HashSet<>();
    //     if (!dfs(0, -1, adjMap, visited)) return false;
    //    // System.out.println(visited);

    //     return visited.size() == n;

    // }

    public boolean validTree(int n, int[][] edges) {
        if (n <= 1) return true;

        DSU dsu = new DSU(n); 

        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                System.out.println(edge[0] + " " + edge[1]);
                return false;
            }
        }

        System.out.println(dsu.components());

        return dsu.components() == 1;

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
