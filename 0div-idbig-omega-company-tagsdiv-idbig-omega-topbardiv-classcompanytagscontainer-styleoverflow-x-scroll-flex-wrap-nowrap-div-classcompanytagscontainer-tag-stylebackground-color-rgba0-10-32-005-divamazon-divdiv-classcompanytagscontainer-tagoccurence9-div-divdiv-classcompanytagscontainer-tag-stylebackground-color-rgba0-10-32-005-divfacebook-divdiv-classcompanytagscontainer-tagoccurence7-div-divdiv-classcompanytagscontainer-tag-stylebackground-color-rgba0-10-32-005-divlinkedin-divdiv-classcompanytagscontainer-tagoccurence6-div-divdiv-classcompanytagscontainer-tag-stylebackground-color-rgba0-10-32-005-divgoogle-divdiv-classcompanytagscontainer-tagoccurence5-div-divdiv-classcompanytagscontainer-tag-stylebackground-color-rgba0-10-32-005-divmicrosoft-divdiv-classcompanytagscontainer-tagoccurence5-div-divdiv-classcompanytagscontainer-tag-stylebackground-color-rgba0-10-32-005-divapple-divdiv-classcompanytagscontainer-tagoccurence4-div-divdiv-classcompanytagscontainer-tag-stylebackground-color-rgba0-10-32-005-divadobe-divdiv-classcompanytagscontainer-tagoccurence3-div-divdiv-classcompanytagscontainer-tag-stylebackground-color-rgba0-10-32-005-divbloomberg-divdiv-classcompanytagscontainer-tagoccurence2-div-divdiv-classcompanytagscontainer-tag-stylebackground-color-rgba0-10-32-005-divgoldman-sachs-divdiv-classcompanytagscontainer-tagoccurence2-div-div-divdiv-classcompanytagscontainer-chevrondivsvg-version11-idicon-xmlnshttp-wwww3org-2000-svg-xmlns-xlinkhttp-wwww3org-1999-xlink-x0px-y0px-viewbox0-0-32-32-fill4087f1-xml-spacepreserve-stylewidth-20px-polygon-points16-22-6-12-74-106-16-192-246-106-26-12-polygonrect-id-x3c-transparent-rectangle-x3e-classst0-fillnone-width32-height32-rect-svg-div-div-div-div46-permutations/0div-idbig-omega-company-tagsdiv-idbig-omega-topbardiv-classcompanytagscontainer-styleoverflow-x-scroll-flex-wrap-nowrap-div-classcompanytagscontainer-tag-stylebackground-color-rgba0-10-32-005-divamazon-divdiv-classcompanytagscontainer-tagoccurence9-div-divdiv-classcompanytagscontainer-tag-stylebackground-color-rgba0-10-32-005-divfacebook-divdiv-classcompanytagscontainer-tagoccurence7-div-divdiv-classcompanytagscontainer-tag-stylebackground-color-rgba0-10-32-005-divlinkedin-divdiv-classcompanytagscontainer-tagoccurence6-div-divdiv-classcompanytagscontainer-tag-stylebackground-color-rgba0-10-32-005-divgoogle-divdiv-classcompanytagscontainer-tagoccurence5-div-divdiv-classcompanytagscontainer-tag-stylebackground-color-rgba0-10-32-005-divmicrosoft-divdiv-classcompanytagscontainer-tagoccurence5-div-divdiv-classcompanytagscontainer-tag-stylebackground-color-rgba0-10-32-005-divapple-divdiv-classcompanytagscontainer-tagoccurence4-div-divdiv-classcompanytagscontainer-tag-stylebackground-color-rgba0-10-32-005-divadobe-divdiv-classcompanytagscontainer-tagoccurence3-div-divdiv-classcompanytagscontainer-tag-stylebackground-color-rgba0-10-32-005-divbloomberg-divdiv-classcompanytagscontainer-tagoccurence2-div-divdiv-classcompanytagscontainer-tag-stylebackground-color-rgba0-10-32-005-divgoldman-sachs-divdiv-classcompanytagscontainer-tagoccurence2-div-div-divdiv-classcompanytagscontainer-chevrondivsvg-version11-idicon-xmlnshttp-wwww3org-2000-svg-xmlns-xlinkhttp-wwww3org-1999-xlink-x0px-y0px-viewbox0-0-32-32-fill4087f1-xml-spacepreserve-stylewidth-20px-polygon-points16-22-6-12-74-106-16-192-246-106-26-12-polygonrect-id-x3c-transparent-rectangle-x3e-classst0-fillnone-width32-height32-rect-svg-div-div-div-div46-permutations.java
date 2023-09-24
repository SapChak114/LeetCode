class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(list,nums,new ArrayList<>());
        return list;
    }
    
    void permute(List<List<Integer>> list, int[] nums, List<Integer> li){
        if(li.size()==nums.length){
            list.add(new ArrayList<>(li));
            return;
        }
        
        for(int i = 0; i<nums.length; i++){
            if(!li.contains(nums[i])){
                li.add(nums[i]);
                permute(list,nums,li);
                li.remove(li.size()-1);
            }
        }
    }
}