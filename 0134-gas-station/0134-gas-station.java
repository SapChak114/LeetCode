class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int res = 0;
        
        for(int x : gas){
            gasSum += x;
        }
        
        for(int x : cost){
            costSum += x;
        }
        
        if(gasSum<costSum){
            return -1;
        }
        
        int total = 0;
        for(int i = 0; i<gas.length; i++){
            total += (gas[i] - cost[i]);
            
            if(total<0){
                total = 0;
                res = i + 1;
            }
        }
        
        return res;
    }
}