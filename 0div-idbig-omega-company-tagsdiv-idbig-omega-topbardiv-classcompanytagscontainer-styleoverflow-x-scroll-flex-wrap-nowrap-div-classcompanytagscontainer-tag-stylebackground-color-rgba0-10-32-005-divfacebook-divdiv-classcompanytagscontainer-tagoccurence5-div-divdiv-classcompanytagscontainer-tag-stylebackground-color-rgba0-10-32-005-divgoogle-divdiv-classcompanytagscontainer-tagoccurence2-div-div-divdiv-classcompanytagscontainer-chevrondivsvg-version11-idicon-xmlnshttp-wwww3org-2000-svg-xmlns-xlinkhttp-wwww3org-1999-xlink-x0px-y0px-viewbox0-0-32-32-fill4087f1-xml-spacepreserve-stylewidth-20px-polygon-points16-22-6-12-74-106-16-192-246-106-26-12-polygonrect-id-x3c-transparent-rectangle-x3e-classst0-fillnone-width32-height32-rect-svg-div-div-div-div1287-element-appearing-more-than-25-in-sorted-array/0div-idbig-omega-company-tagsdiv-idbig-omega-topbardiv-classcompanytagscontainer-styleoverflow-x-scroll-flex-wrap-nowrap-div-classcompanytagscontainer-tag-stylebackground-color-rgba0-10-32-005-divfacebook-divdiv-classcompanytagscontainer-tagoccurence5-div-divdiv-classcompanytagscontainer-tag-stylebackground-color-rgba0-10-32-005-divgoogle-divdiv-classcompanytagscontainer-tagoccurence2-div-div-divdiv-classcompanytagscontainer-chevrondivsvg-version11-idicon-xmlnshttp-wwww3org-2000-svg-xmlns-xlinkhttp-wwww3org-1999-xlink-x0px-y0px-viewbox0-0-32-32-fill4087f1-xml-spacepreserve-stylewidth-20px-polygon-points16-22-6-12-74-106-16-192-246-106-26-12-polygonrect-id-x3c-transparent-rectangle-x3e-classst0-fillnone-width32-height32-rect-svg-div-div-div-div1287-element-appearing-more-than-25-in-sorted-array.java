class Solution {
    public int findSpecialInteger(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        
        int n = arr.length;
        for(int i = 0; i<n; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        int p25 = n/4;
        
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue()>p25) return e.getKey();
        }
        
        return 0;
    }
}