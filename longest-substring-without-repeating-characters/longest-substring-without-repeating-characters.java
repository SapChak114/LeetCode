class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int ans = 0;
        for(int k = 0; k<s.length(); k++){
            Set<Character> set = new HashSet<>();
            if(!set.contains(s.charAt(k))) set.add(s.charAt(k));
            int check = 1;
            for(int i = k+1; i<s.length(); i++){
                if(!set.contains(s.charAt(i))){
                    set.add(s.charAt(i));
                    check++;
                } else{
                    break;
                }
            }
            ans = Math.max(ans,check);
        }
        return ans;
    }
}