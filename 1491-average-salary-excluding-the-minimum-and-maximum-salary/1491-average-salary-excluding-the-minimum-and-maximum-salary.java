class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        //System.out.println(min+"  "+max);
        //[8000,9000,2000,3000,6000,1000]
        for(int i = 0; i<salary.length; i++){
            min = Math.min(min,salary[i]);
            max = Math.max(max,salary[i]);
            //System.out.println(salary[i]);
        }
        int count = 0;
        double sal = 0;
        //System.out.println(min+"  "+max);
        for(int i = 0; i<salary.length; i++){
            if(salary[i]!=min && salary[i]!=max){
                sal += salary[i];
                count++;
            }
        }
        
        return sal/count;
    }
}