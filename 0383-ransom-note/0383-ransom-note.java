class Solution {
    public boolean canConstruct(String ran, String mag) {
        Map<Character,Integer> map = new HashMap<>();
        
        for(char c : mag.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        for(char c : ran.toCharArray()){
            if(map.containsKey(c) && map.get(c)>0){
                map.put(c,map.get(c)-1);
                continue;
            }
            return false;
        } 
        
        return true;
    }
}