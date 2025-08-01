class Solution {
    List<Integer>[] adjList;
    boolean[] vis;
    int n;
    public int removeStones(int[][] stones) {
        n = stones.length;
        adjList = new ArrayList[n];
        for (int i = 0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i<n; i++) {
            for(int j=i+1;j<n;j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }
        
        vis = new boolean[n];
        int count = 0;
        for (int i = 0; i<n; i++) {
            if (!vis[i]) {
                dfs(i);
                count++;
            }
        }
        
        return n - count;
    }
    
    void dfs(int node) {
        vis[node] = true;
        for (int nei : adjList[node]) {
            if (!vis[nei]) {
                dfs(nei);
            }
        }
    }
}
/**
[[0,0],
[0,1],
[1,0],[1,2],[2,1],[2,2]]

0 0 0
0 0 1
0 0 0

count = 3
1 0 0
1 0 0
0 0 1

count = 4
 */