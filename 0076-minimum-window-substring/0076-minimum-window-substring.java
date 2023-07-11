class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, count = 0, len = 0, start = -1, end = 100007;
        int n = t.length(), m = s.length();
        
        if(n>m) return "";
        
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        while(right<m){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                if(map.get(c)>0){
                    count++;
                }
                map.put(c,map.getOrDefault(c,0)-1);
            }
            
            while(count==n){
                if(right-left+1 < end-start+1){
                    start = left;
                    end = right;
                }
                
                char lc = s.charAt(left);
                if(map.containsKey(lc)){
                    map.put(lc,map.getOrDefault(lc,0)+1);
                    if(map.get(lc)>0){
                        count--;
                    }
                }
                left++;
            }
            
            right++;
        }
        if(start==-1) return "";
        return s.substring(start,end+1);
    }
    
    
}