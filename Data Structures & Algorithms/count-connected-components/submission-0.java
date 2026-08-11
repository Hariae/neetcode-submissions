class DSU {
    int components;
    int[] parent;
    int[] size;

    DSU(int n) {
        this.components = n;
        this.parent = new int[n];
        this.size = new int[n];

        for (int i=0;i<n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return;

        if (size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }

        components--;
        return;
    }

    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }

        return parent[u];
    }

    public int components() {
        return components;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        return dsu.components();
    }
}
