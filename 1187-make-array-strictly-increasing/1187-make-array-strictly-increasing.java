class Solution {
    Map<Pair<Integer,Integer>,Integer> map;
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        map = new HashMap<>();
        Arrays.sort(arr2);
        int res = dfs(0,-1,arr1,arr2);
        return res==2_001?-1:res;
    }
    
    int dfs(int i, int prev, int[] arr1, int[] arr2){
        if(i==arr1.length){
            return 0;
        }
        
        if(map.containsKey(new Pair(i,prev))) return map.get(new Pair(i,prev));
        
        int cost = 2_001;
        if(prev<arr1[i]){
            cost = dfs(i+1,arr1[i],arr1,arr2);
        }
        
        int idx = bs(arr2,prev);
        if(idx < arr2.length){
            cost = Math.min(cost,1+dfs(i+1,arr2[idx],arr1,arr2));
        }
        
        map.put(new Pair(i,prev),cost);
        
        return cost;
    }
    
    int bs(int[] arr, int prev){
        int lo = 0;
        int hi = arr.length;
        
        while(lo<hi){
            int mid = (lo+hi)/2;
            
            if(arr[mid]<=prev){
                lo = mid + 1;
            } else{
                hi = mid;
            }
        }
        
        return lo;
    }
}