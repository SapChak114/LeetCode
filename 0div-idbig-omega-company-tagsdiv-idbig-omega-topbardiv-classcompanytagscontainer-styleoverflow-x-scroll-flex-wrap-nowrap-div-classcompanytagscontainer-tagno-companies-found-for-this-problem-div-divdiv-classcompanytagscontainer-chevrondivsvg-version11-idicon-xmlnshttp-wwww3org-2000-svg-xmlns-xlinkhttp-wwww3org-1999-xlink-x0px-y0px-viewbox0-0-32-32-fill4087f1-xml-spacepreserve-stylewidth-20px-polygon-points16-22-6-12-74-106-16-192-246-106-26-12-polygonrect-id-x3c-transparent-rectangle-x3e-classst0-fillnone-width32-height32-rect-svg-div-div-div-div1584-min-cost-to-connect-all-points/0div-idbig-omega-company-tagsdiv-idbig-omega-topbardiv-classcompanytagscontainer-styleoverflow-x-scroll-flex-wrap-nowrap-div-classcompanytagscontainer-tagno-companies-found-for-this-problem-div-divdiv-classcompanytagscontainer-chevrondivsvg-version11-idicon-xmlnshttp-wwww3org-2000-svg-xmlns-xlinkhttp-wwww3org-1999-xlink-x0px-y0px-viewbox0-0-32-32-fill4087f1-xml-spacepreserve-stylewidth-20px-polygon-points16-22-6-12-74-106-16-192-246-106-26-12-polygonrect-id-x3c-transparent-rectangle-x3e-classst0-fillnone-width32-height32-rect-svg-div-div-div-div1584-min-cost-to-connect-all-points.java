class DSU{
    int[] parent;
    int[] size;
    
    public DSU(int n){
        parent = new int[n+1];
        size = new int[n+1];
        
        for(int i = 1; i<=n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    int findParent(int a){
        if(parent[a]==a){
            return a;
        }
        
        return parent[a] = findParent(parent[a]);
    }
    
    boolean union(int a, int b){
        int pa = findParent(a);
        int pb = findParent(b);
        
        if(pa==pb){
            return true;
        }
        
        if(size[pa]>=size[pb]){
            parent[pb] = pa;
            size[pa] += size[pb];
        } else{
            parent[pa] = pb;
            size[pb] += size[pa];
        }
        
        return false;
    }
}

class Data implements Comparable<Data>{
    int dist;
    int u;
    int v;
    
    public Data(int dist, int u, int v){
        this.dist = dist;
        this.u = u;
        this.v = v;
    }
    
    public int compareTo(Data d){
        return Integer.compare(this.dist,d.dist);
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        List<Data> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                list.add(new Data(Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]),i,j));   
            }
        }
        
        Collections.sort(list);
        
        int minDist = 0;
        int edgeAdded = 0;
        DSU dsu = new DSU(n);
        
        for(Data d : list){
            minDist += dsu.union(d.u,d.v)?0:d.dist;
        }
        
        return minDist;
    }
}