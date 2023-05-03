class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        for(int i : nums1) set1.add(i);
        for(int i : nums2) set2.add(i);
        
        for(int i : nums2){
            if(set1.contains(i)){
                set1.remove(i);
            }
        }
        
        for(int i : nums1){
            if(set2.contains(i)){
                set2.remove(i);
            }
        }
        
        List<Integer> al1 = new ArrayList<>(set1);
        List<Integer> al2 = new ArrayList<>(set2);
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(al1);
        ans.add(al2);
        
        return ans;
    }
}