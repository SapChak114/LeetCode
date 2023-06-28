class Pair implements Comparable<Pair>{
    int u;
    double w;
    
    public Pair(int u, double w){
        this.u=u;
        this.w=w;
    }
    
    public int compareTo(Pair b){
        return Double.compare(this.w,b.w);
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Pair>[] adjList = new ArrayList[n];
        
        for(int i = 0; i<n; i++) adjList[i] = new ArrayList<>();
        
        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            adjList[u].add(new Pair(v,w));
            adjList[v].add(new Pair(u,w));
        }
        
        double[] dis = new double[n];
        Arrays.fill(dis,Double.MIN_VALUE);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Pair(start,1));
        dis[start]=1;
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            
            for(Pair edge : adjList[p.u]){
                if(dis[edge.u]<p.w*edge.w){
                    dis[edge.u]=p.w*edge.w;
                    pq.add(new Pair(edge.u,dis[edge.u]));
                }
            }
        }
        
        return dis[end];
        
    }
}