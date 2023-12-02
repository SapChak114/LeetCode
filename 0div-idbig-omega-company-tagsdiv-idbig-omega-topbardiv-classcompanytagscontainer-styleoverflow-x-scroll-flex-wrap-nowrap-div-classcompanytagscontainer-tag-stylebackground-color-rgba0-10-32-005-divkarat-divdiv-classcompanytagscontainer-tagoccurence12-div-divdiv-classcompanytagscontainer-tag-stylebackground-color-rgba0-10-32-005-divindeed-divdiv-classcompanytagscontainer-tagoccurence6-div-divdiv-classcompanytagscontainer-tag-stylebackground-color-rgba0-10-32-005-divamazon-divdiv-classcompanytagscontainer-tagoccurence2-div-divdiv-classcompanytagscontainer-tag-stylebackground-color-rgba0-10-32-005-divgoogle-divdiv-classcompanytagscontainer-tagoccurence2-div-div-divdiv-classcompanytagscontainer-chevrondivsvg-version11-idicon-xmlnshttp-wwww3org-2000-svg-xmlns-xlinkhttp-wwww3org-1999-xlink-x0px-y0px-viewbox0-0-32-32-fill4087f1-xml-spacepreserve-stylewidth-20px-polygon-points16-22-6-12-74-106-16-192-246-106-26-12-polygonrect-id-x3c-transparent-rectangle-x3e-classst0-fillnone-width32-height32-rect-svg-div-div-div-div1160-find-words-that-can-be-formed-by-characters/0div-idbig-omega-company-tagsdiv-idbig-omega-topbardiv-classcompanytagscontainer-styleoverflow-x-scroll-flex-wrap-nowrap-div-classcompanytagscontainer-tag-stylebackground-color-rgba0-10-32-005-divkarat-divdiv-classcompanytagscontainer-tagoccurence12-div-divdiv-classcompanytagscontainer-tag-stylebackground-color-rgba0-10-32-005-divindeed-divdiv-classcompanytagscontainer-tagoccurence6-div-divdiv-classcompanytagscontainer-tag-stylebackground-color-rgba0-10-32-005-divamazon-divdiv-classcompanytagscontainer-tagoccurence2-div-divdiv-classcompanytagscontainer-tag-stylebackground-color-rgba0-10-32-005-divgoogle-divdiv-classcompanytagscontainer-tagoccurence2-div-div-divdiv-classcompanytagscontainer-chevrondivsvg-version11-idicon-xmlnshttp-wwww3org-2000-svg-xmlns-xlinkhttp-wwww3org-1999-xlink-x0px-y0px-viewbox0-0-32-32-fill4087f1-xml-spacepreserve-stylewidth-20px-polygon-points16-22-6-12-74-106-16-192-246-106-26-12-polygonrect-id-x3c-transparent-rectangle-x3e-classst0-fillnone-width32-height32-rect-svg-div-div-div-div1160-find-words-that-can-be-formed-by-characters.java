class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : chars.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
        
        int ans = 0;
        for(String w : words){
            int wl = w.length();
            int count = 0;
            Map<Character,Integer> map2 = new HashMap<>(map);
            for(char c : w.toCharArray()){
                if(map2.containsKey(c)) {
                    int freq = map2.get(c);
                    map2.put(c,--freq);
                    if(freq==0) map2.remove(c);
                    count++;
                }
            }
            if(count == wl) ans += wl;
        }
        
        return ans;
    }
}