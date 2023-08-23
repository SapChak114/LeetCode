class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        
        for(int i = 0; i<freq.length; i++){
            if(freq[i]>0){
                maxHeap.add(new int[]{i,freq[i]});
            }
        }
        
        StringBuilder st = new StringBuilder();
        
        int[] prev = new int[2];
        while(!maxHeap.isEmpty()){
            int[] now = maxHeap.poll();
            st.append((char)(now[0]+'a'));
            
            if(prev[1]>0){
                maxHeap.add(new int[]{prev[0],prev[1]});
            }
            
            prev = new int[]{now[0],--now[1]};
            
        }
        
        return st.length()!=s.length()?"":st.toString();
    }
}