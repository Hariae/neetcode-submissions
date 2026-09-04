class DSU {
    int N;
    int[] size;
    int[] parent;

    public DSU(int N) {
        this.N = N + 1;
        this.size = new int[N + 1];
        this.parent = new int[N + 1];

        for (int i=1;i<=N;i++) {
            size[i] = 1;
            parent[i] = i;
        }

    }

    public int find(int u) {

        if (parent[u] == u) {
            return u;
        }

        return find(parent[u]);
    }

    public boolean merge(int u, int v) {

        u = find(u);
        v = find(v);

        if (u == v) return false;

        if (size[u] > size[v]) {
            parent[v] = u;
            size[u] = size[u] + size[v];
            size[v] = 0;
        } else {
            parent[u] = v;
            size[v] = size[v] + size[u];
            size[u] = 0;
        }

        return true;

    }
}



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


    // public int[] findRedundantConnection(int[][] edges) {

    //     int n = edges.length;

    //     HashMap<Integer, List<Integer>> adjMap = new HashMap<>();

    //     for (int i=1;i<=n;i++) {
    //         adjMap.put(i,new ArrayList<>());
    //     }

    //     for (int[] edge : edges) {
    //         int src = edge[0], dest = edge[1];
            
    //         if (isConnected(src, dest, new HashSet<>(), adjMap)) {
    //             return new int[]{src, dest};
    //         }

    //         adjMap.get(src).add(dest);
    //         adjMap.get(dest).add(src);


    //     }

    //     return new int[]{-1, -1};
        
    // }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            if (!dsu.merge(edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
        }

        return new int[]{-1, -1};


    }
}