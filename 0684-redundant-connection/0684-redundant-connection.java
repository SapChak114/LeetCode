class DSU{
    int[] parent;
    int[] size;

    public DSU(int n){
        parent = new int[n+1];
        size = new int[n+1];

        for (int i = 1; i<=n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findParent(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a]=findParent(parent[a]);
    }

    boolean union(int a, int b){
        int pa = findParent(a);
        int pb = findParent(b);

        if (pa == pb) {
            return true;
        }

        if (size[pa] >= size[pb]) {
            parent[pb] = pa;
            size[pa] += size[pb];
        } else {
            parent[pa] = pb;
            size[pb] += size[pa];
        }
        return false;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);

        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
        }

        return new int[]{};
    }
}
/**
1 -> 2
2 -> 1, 3


 */