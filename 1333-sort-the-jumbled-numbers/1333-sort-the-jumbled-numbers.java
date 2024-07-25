class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            ans.add(num);
        }
        Collections.sort(ans, (a,b) -> Integer.compare(f(a, mapping), f(b, mapping)));
        
        for (int i = 0; i<nums.length; i++) {
            nums[i] = ans.get(i);
        }

        return nums;
    }

    Integer f(int num, int[] mapping) {
        String val = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        for (char c : val.toCharArray()) {
            int no = c-'0';
            sb.append(mapping[no]);
        }
        return Integer.valueOf(sb.toString());
    }
}
/**
0 1 2 3 4 5 6 7 8 9
[8,9,4,0,2,1,3,5,7,6],

[991,338,38]

669, 007, 07

338, 38, 991

 */