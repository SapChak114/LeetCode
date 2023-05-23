class Pair{
    int num;
    int freq;
    
    public Pair(int num, int freq){
        this.num=num;
        this.freq=freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
               map.put(nums[i],map.get(nums[i])+1); 
            } else{
                map.put(nums[i],1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2)->o2.freq-o1.freq);
        for(Integer e : map.keySet()){
            pq.add(new Pair(e,map.get(e)));
        }
        int[] ans = new int[k];
        int x = 0;
        while(k-- > 0){
            ans[x++]=pq.poll().num;
        }
        
        return ans;
    }
}