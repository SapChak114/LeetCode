class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, r = 10000007;
        
        while(l<r){
            int mid = l + (r-l)/2;
            
            double time = 0;
            for(int d : dist){
                if(time>(int)time) time = (double)((int)time+1);
                time += ((double)d)/((double)mid);
            }
            if(time>hour){
                l = mid + 1;
            } else{
                r = mid;
            }
        }
        
        return l==10000007?-1:l;
    }
}