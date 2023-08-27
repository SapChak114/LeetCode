class Solution {
    Map<Integer, Integer> stoneIndex;
    Set<String> cache;
    int [] stones;
    public boolean canCross(int[] stones) {
        stoneIndex = new HashMap<>();
        for(int i = 0 ; i < stones.length ; i++ ) stoneIndex.put(stones[i] , i);
        cache = new HashSet<>();
        this.stones = stones;
        return isReach(0, 0);
    }
    private boolean isReach(int idx, int prevJumpIdx){
        if(idx == stones.length - 1) return true;
        if(cache.contains(idx + " " + prevJumpIdx)) return false;
        for(int i = prevJumpIdx - 1 ; i <= prevJumpIdx + 1 ; i++){
            if(i > 0 && stoneIndex.containsKey(stones[idx] + i) && isReach(stoneIndex.get(stones[idx] + i), i)) return true;
        }
        cache.add(idx +" "+ prevJumpIdx);
        return false;
    }

}