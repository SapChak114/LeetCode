class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> map = new HashMap<>();
        
        int answer = 1;
        for(int a : arr){
            int no = map.getOrDefault(a-difference,0);
            map.put(a,no+1);
            answer = Math.max(answer,map.get(a));
        }
        
        return answer;
    }
}