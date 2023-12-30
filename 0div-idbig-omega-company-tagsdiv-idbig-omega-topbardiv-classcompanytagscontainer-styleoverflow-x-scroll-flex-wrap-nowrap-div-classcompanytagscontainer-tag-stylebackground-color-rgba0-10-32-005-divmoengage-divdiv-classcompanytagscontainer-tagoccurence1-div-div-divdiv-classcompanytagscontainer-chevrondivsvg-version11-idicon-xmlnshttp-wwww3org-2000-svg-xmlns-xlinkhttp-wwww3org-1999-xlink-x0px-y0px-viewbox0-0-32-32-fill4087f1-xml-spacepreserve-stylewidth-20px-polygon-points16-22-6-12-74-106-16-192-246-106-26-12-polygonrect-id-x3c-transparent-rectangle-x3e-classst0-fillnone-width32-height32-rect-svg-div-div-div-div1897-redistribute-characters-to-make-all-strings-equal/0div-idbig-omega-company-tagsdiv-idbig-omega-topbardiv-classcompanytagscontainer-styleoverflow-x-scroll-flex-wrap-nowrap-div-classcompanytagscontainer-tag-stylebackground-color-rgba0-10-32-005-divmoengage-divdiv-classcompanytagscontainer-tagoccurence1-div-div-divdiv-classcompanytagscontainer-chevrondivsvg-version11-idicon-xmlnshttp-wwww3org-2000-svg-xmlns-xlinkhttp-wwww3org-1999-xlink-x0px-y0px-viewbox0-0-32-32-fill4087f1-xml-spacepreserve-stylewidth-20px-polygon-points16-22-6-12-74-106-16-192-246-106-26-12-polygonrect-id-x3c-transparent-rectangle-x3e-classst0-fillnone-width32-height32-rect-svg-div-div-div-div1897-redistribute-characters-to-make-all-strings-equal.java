class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character,Integer> map = new HashMap<>();
        
        for(String w : words){
            for(char c : w.toCharArray()){
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        
        int n = words.length;
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            if(e.getValue()%n!=0) return false;
        }
        
        return true;
    }
}