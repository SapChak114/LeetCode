class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        char[] ch = s.toCharArray();
        int count = 0;
        int max = 0;
        for(int i =0 ; i<ch.length; i++){
            if(set.contains(ch[i])){
                count++;
            } 
            if(i>=k && set.contains(ch[i-k])){
                count--;
            }
            max = Math.max(max,count);
        }
        
        return max;
    }
}