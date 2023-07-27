class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        
        int i = 0, n = intervals.length;
        
        List<List<Integer>> li = new ArrayList<>();
        while(i<n){
            int start = intervals[i][0];
            int end = intervals[i][1];
            i++;
            while(i<n && end>=intervals[i][0]){
                end = Math.max(end,intervals[i][1]);
                i++;
            }
            
            List<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(end);
            li.add(list);
        }
        
        int[][] res = new int[li.size()][2];
        
        for(i = 0; i<li.size(); i++){
            res[i][0] = li.get(i).get(0);
            res[i][1] = li.get(i).get(1);
        }
        
        return res;
    }
}