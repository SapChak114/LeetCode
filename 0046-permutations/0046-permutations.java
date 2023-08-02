class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        back(list,nums,new ArrayList<>());
        return list;
    }
    
    void back(List<List<Integer>> list, int[] nums, List<Integer> li){
        if(li.size()==nums.length){
            list.add(new ArrayList<>(li));
            return;
        }
        
        for(int n : nums){
            if(!li.contains(n)){
                li.add(n);
                back(list,nums,li);
                li.remove(li.size()-1);
            }
        }
    }
}