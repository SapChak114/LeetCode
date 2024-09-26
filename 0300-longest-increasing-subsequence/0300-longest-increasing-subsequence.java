class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length; 

        List<Integer> li = new ArrayList<>();
        for (int num : nums) {
            int idx = bs(li, num);
            if (idx == li.size()) {
                li.add(num);
            }
            li.set(idx, num);
        }

        return li.size();
    }

    int bs(List<Integer> li, int targ) {
        int l = 0, r = li.size();

        while (l<r) {
            int mid = l + (r - l)/2;

            if (li.get(mid) == targ) {
                return mid;
            } else if (li.get(mid) < targ) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}