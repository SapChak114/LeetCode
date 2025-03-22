class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n+1];
        size = new int[n+1];

        for (int i = 0; i<=n; i++) {
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
// class UnionFind {

//     int[] parent;
//     int[] size; // Tracks size of each component

//     UnionFind(int n) {
//         parent = new int[n];
//         size = new int[n];
//         Arrays.fill(parent, -1);
//         Arrays.fill(size, 1);
//     }

//     // Find root of component with path compression
//     int find(int node) {
//         if (parent[node] == -1) {
//             return node;
//         }
//         return parent[node] = find(parent[node]);
//     }

//     // Union by size
//     void union(int node1, int node2) {
//         int root1 = find(node1);
//         int root2 = find(node2);

//         if (root1 == root2) {
//             return;
//         }

//         // Merge smaller component into larger one
//         if (size[root1] > size[root2]) {
//             parent[root2] = root1;
//             size[root1] += size[root2];
//         } else {
//             parent[root1] = root2;
//             size[root2] += size[root1];
//         }
//     }
// }
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