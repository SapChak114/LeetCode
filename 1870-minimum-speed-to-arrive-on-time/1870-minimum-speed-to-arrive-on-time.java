class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, r = 10000007;
        
        while(l<r){
            int mid = l + (r-l)/2;
            double totalTime = 0;
            for(int d : dist){
                if(totalTime>(int)totalTime) totalTime = (double)((int)totalTime+1);
                totalTime += ((double)d)/((double)mid);
            }
            if(totalTime>hour) l = mid+1;
            else r = mid;
        }
        
        return l==10000007?-1:l;
    }
}