class Solution {
    public int getBitMask(String str){
        int mask =0;
        for(char ch : str.toCharArray()){
            mask = mask | (1<<(ch-'a'));
        }
        return mask;
    }
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> startSet = new HashSet<>();
        for(String word : startWords){
            startSet.add(getBitMask(word));
        }
        int res = 0;
        for(String target : targetWords){
            int targetMask = getBitMask(target);
            for(char ch : target.toCharArray()){
                int submask = targetMask ^ (1<<(ch-'a'));
                if(startSet.contains(submask)){
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}