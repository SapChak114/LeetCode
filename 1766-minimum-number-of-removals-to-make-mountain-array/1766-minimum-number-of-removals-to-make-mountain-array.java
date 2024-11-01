class Solution {
    public int minimumMountainRemovals(int[] nums) {
        List<Integer> integerList = Arrays.stream(nums)
                                          .boxed()
                                          .collect(Collectors.toList());
        List<Integer> leftList = findSize(integerList);
        Collections.reverse(integerList);
        List<Integer> rightList = findSize(integerList);
        Collections.reverse(rightList);

        int min = 0;

        for (int i = 0; i<leftList.size(); i++) {
            if (leftList.get(i) > 1 && rightList.get(i) > 1) {
                min = Math.max(min, leftList.get(i) + rightList.get(i)-1);
            }
        }
        return nums.length - min;

    }

    List<Integer> findSize(List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> sizeList = new ArrayList<>();
        for (int num : nums) {
            int idx = bs(num, list);
            if (idx == list.size()) {
                list.add(num);
            }
            list.set(idx, num);
            sizeList.add(list.size());
        }
        return sizeList;
    }

    int bs(int targ, List<Integer> list) {
        int l = 0, r = list.size();

        while (l < r) {
            int m = (l + r) >> 1;

            if (list.get(m) == targ) {
                return m;
            } else if (list.get(m) < targ) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}