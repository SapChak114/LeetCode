class Solution {
    public int[] sortByBits(int[] arr) {

        List<Integer> nums = new ArrayList<>();
        for (int num : arr) {
            nums.add(num);
        }

        Collections.sort(nums, (a, b) -> {
            if (Integer.bitCount(a) == Integer.bitCount(b)) {
                return a - b;
            }

            return Integer.bitCount(a) - Integer.bitCount(b);
        });

        for (int i = 0; i<arr.length; i++) {
            arr[i] = nums.get(i);
        }

        return arr;
    }
}