class Pair{
    int x;
    int y;
    int w;

    public Pair(int x, int y, int w){
        this.x = x;
        this.y = y;
        this.w = w;
    }
}
class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int minCost(int[][] B) {
        int n = B.length, m = B[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2)->o1.w-o2.w);
        pq.add(new Pair(0,0,0));

        int[][] dist = new int[n][m];

        for(int[] d : dist){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();

            if (p.x == n - 1 && p.y == m - 1) {
                return p.w;
            }
            
            for(int i = 0; i<4; i++){
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                int newCost = p.w + (B[p.x][p.y] == i + 1 ? 0 : 1);
                if (x >= 0 && x < n && y >= 0 && y < m && dist[x][y] > newCost) {
                    dist[x][y] = newCost;
                    pq.add(new Pair(x, y, newCost));
                }
            }
        }

        return -1;
    }
}