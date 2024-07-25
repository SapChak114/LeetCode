class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    void mergeSort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }

        int mid = (i+j) >> 1;
        mergeSort(nums, i, mid);
        mergeSort(nums, mid+1, j);
        merge(nums, i, mid, j);
    }

    void merge(int[] nums, int i, int m, int j) {
        List<Integer> list = new ArrayList<>();
        int l = i;
        int r = m + 1;

        while (l <= m && r <= j) {
            if (nums[l] <= nums[r]) {
                list.add(nums[l]);
                l++;
            } else {
                list.add(nums[r]);
                r++;
            }
        }

        while (l <= m) {
            list.add(nums[l++]);
        }

        while (r <= j) {
            list.add(nums[r++]);
        }

        for (int a = 0; a<list.size(); a++) {
            nums[i+a] = list.get(a);
        }
    }
}