class Solution {
    public int findKthPositive(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
            set.add(num);
        }

        boolean flag = false;
        for (int num = 1; num<=max; num++) {
            if (!set.contains(num)) {
                list.add(num);
                flag = true;
            }
        }

        return flag ? k <= list.size() ? list.get(k-1) : (max + k) - list.size() : max + k;
    }
}