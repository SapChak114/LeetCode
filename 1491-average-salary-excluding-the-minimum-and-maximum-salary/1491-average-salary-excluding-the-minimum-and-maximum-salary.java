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
        // int count = 0;
        // double sal = 0;
        // for(int i = 0; i<salary.length; i++){
        //     if(salary[i]!=min && salary[i]!=max){
        //         sal += salary[i];
        //         count++;
        //     }
        // }
        sal -= min;
        sal -= max;
        
        return sal/(salary.length-2);
    }
}