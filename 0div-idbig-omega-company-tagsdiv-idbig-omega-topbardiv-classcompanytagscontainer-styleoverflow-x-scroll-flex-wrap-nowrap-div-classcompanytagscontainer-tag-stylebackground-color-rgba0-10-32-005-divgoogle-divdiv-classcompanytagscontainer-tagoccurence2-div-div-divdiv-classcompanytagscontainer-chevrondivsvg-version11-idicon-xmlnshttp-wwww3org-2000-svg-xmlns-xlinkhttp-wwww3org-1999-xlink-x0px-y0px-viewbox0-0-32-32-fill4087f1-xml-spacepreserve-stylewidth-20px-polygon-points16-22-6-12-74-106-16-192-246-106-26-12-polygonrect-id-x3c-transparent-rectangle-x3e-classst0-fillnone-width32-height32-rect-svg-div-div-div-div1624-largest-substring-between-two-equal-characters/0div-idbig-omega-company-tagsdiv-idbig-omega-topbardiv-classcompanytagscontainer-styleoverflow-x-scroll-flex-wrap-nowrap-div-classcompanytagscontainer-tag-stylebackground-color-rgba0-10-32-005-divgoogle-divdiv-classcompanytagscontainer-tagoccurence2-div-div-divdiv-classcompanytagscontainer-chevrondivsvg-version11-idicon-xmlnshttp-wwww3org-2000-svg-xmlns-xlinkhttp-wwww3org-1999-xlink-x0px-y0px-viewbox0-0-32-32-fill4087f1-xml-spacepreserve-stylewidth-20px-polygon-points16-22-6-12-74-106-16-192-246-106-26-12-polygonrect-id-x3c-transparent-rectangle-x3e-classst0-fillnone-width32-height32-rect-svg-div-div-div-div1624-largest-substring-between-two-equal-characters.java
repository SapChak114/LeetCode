class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length(), max = Integer.MIN_VALUE;
        
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,i);
            } else{
                max = Math.max(max,i-map.get(c)-1);
            }
        }
        
        return max==Integer.MIN_VALUE?-1:max;
    }
}