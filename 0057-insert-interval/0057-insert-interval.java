class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int[] in : intervals){
            int start = in[0];
            int end = in[1];
            List<Integer> li = new ArrayList<>();
            li.add(start);
            li.add(end);
            res.add(li);
        }
        
        int start = newInterval[0];
        int end = newInterval[1];
        List<Integer> li = new ArrayList<>();
        li.add(start);
        li.add(end);
        res.add(li);
        
        Collections.sort(res,(a,b)->Integer.compare(a.get(0),b.get(0)));
        
        System.out.println(res);
        int i = 0;
        while(i<res.size()){
            start = res.get(i).get(0);
            end = res.get(i).get(1);
            
            i++;
            while(i<res.size() && end>=res.get(i).get(0)){
                end = Math.max(end,res.get(i).get(1));
                i++;
            }
            
            List<Integer> al = new ArrayList<>();
            al.add(start);
            al.add(end);
            ans.add(al);
            
        }
        System.out.println(ans);
        int[][] an = new int[ans.size()][2];
        
        for(i = 0; i<an.length; i++){
            an[i][0] = ans.get(i).get(0);
            an[i][1] = ans.get(i).get(1);
        }
        
        return an;
        
    }
}