class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = groupSizes.length;
        
        for(int i = 0; i<n; i++){
            if (!map.containsKey(groupSizes[i])) {
                map.put(groupSizes[i], new ArrayList<>());
            }
            map.get(groupSizes[i]).add(i);
            if(map.get(groupSizes[i]).size()==groupSizes[i]){
                ans.add(map.get(groupSizes[i]));
                map.remove(groupSizes[i]);
            }
        }
        
        return ans;
    }
}