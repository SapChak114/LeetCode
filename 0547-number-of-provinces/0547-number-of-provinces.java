class DSU{
    int[] size;
    int[] parent;
    
    public DSU(int length){
        size = new int[length];
        parent = new int[length];
        
        for(int i = 0; i<length; i++){
            parent[i]=i;
            size[i]=1;
        }
    }
        
    int findParent(int a){
        if(a==parent[a]){
            return parent[a];
        }

        return parent[a] = findParent(parent[a]);
    }
        
    boolean union(int a, int b){
        int pa = findParent(a);
        int pb = findParent(b);

        if(parent[pa]==parent[pb]){
            return true;
        }

        if(size[pa]>=size[pb]){
            parent[pb]=pa;
            size[pa]+=size[pb];
        } else{
            parent[pa]=pb;
            size[pb]+=size[pa];
        }

        return false;
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        DSU dsu = new DSU(isConnected.length);
        
        for(int i = 0; i<isConnected.length; i++){
            for(int j = 0; j<isConnected[i].length; j++){
                if(isConnected[i][j]==1){
                    dsu.union(i,j);
                }
            }
        }
        
        int count = 1;
        for(int i = 0; i<isConnected.length-1; i++){
            if(!dsu.union(i,i+1)){
                count++;
            }
        }
        
        return count;
    }
}