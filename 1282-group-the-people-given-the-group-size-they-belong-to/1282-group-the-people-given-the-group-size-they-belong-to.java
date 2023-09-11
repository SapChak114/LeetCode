class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = groupSizes.length;
        
        for(int i = 0; i<n; i++){
            if (!map.containsKey(groupSizes[i])) {
                map.put(groupSizes[i], new ArrayList<>());
            }
            List<Integer> li = map.get(groupSizes[i]);
            li.add(i);
            if(li.size()==groupSizes[i]){
                ans.add(li);
                map.remove(groupSizes[i]);
            }
        }
        
        return ans;
    }
}