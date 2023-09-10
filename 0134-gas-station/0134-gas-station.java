class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int g = IntStream.of(gas).sum();
        int c = IntStream.of(cost).sum();
        
        if(g<c) return -1;
        
        int total = 0, sum = 0;
        
        for(int i = 0; i<gas.length; i++){
            total += gas[i] - cost[i];
            if(total<0){
                total = 0;
                sum = i+1;
            }
        }
        
        return sum;
    }
}