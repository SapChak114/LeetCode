class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasCount = 0, costCount = 0;
        
        for(int g : gas) gasCount += g;
        
        for(int c : cost) costCount += c;
        
        if(gasCount<costCount) return -1;
        
        int total = 0, res = 0;
        for(int i = 0; i<gas.length; i++){
            total += gas[i]-cost[i];
            
            if(total<0){
                total = 0;
                res = i + 1;
            }
        }
        
        return res;
    }
}