class Solution {
    public int minDeletions(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        
        for(int i = 0; i<n; i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
       
        Set<Integer> set = new HashSet<>();
        
        int ans = 0;
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            int freq = e.getValue();
            while(set.contains(freq)){
                ans++;
                freq--;
            }
            
            if(freq>0) set.add(freq);
        }
               
        return ans;
    }
}