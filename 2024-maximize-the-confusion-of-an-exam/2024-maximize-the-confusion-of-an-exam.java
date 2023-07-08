class Solution {
    public int maxConsecutiveAnswers(String key, int k) {
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i = 0; i<k; i++){
            map.put(key.charAt(i),map.getOrDefault(key.charAt(i),0)+1);
        }
        
        int left = 0, res = k;
        for(int i = k; i<key.length(); i++){
            map.put(key.charAt(i),map.getOrDefault(key.charAt(i),0)+1);
            
            while(Math.min(map.getOrDefault('T',0),map.getOrDefault('F',0))>k){
                map.put(key.charAt(left),map.getOrDefault(key.charAt(left),0)-1);
                left++;
            }
            
            res = Math.max(res,i-left+1);
        }
        
        return res;
    }
}