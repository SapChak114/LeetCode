class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] counts = new int[26];
        for(char c : chars.toCharArray()) counts[c-'a']++;
        
        int ans = 0;
        for(String w : words){
            int[] check = new int[26];
            boolean flag = true;
            for(char c : w.toCharArray()) check[c-'a']++;
            
            for(int i = 0; i<check.length; i++){
                if(counts[i]<check[i]) flag = false;
            }
            
            if(flag) ans += w.length();
        }
        
        return ans;
    }
}