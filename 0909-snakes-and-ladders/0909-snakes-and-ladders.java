class Vertex implements Comparable<Vertex>{
    int dist;
    int label;
    
    public Vertex(int dist,int label){
        this.dist=dist;
        this.label=label;
    }
    
    public int compareTo(Vertex v) {
        return this.dist - v.dist;
    }
}

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        
        Pair<Integer,Integer>[] cells = new Pair[n*n+1];
        
        Integer[] columns = new Integer[n];
        
        for(int i = 0; i<n; i++){
            columns[i]=i;
        }
        
        int pos = 1;
        for(int i = n-1; i>=0; i--){
            for(int col : columns){
                cells[pos++]=new Pair(i,col);
            }
            Collections.reverse(Arrays.asList(columns));
        }
        
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        int[] dist = new int[n*n+1];
        Arrays.fill(dist,-1);
        pq.add(new Vertex(0,1));
        dist[1]=0;
        
        while(!pq.isEmpty()){
            Vertex vertex = pq.poll();
            int d = vertex.dist, curr = vertex.label;
            if(d!=dist[curr]){
                continue;
            }
            for(int next = curr+1; next<=Math.min(curr+6,n*n); next++){
                int row = cells[next].getKey(), col = cells[next].getValue();
                int dest = board[row][col]!=-1?board[row][col]:next;
                if(dist[dest]==-1 || dist[curr] + 1 < dist[dest]){
                    dist[dest] = dist[curr]+1;
                    pq.add(new Vertex(dist[dest],dest));
                }
            }
        }
        
        return dist[n*n];
    }
}