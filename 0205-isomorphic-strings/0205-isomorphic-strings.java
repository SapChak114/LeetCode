class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        if(n!=m) return false;
        
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        for(char c : t.toCharArray()){
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        
        if(map.size()!=map2.size()) return false;
        
        Map<Character,Character> mp = new HashMap<>();
        
        for(int i = n-1; i>=0; i--){
            if(!mp.containsKey(s.charAt(i))){
                mp.put(s.charAt(i),t.charAt(i));
            }
            else{
                if(mp.get(s.charAt(i))!=t.charAt(i)) return false;
            }
        }
        
        return true;
    }
}