class DSU {
    int[] size;
    int[] parent;

    public DSU(int n) {
        this.size = new int[n+1];
        this.parent = new int[n+1];

        for (int i = 0; i<size.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }


    int findParent(int val) {
        if (parent[val] == val) {
            return val;
        }

        return parent[val] = findParent(parent[val]);
    }

    boolean union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv) {
            return true;
        }

        if (size[pu] > size[pv]) {
            parent[pv] = parent[pu];
            size[pu] += size[pv];
        } else {
            parent[pu] = parent[pv];
            size[pv] += size[pu];
        }

        return false;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);

        for (int i = 0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (dsu.union(u,v)) {
                return new int[]{u, v};
            }
        }

        return new int[]{};
    }
}