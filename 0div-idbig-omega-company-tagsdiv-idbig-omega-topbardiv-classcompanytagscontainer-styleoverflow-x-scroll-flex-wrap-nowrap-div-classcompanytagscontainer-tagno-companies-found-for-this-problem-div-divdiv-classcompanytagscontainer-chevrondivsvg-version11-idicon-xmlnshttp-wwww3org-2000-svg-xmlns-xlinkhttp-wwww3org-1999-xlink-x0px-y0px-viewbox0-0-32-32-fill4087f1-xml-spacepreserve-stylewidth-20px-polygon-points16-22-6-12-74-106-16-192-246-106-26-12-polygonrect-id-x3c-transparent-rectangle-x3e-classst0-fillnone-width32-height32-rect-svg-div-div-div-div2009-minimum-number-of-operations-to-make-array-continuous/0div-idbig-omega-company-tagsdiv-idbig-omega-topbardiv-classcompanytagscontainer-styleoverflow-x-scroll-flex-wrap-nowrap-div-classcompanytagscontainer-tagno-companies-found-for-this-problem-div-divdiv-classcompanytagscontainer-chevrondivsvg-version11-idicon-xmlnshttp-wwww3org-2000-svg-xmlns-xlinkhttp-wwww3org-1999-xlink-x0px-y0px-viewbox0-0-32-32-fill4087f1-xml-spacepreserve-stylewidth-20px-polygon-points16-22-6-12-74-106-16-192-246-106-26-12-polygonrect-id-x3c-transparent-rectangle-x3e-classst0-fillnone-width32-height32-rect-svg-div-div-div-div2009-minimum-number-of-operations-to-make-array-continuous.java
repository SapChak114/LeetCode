class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = n;
        
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) set.add(num);
        
        int[] arr = new int[set.size()];
        
        int idx = 0;
        
        for(int num : set) arr[idx++] = num;
        Arrays.sort(arr);
        
        for(int i = 0; i<arr.length; i++){
            int left = arr[i];
            int right = left + n - 1;
            int j = bs(arr,right);
            int count = j - i;
            ans = Math.min(ans,n-count);
        }
        
        return ans;
    }
    
    int bs(int[] arr, int targ){
        int l = 0, r = arr.length;
        
        while(l<r){
            int mid = l + (r-l)/2;
            if(targ < arr[mid]){
                r = mid;
            } else{
                l = mid + 1;
            }
        }
        
        return l;
    }
}