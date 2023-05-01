class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sal = 0;
        for(int i = 0; i<salary.length; i++){
            min = Math.min(min,salary[i]);
            max = Math.max(max,salary[i]);
            sal += salary[i];
        }
        sal -= (min+max);
        return sal/(salary.length-2);
    }
}