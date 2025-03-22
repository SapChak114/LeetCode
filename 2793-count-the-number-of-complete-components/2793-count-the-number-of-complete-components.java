class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

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
    public int countCompleteComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        Map<Integer, Integer> counter = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            dsu.union(u, v);
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int cid = dsu.find(u);
            counter.put(cid, counter.getOrDefault(cid, 0) + 1);
        }

        int ans = 0;
        Set<Integer> vis = new HashSet<>();
        for (int node = 0; node<n; node++) {
            int cid = dsu.find(node);
            if (vis.contains(cid)) {
                continue;
            }
            vis.add(cid);

            int nodes = dsu.size[cid];
            int edgs = counter.getOrDefault(cid, 0);

            System.out.println("cid : "+cid +", nodes : "+nodes+", edgs : "+edgs+", exp : "+((nodes * (nodes - 1)) / 2));
            if (edgs == ((nodes * (nodes - 1)) / 2)) {
                ans++;
            }
        }
        
        return ans;
    }
}