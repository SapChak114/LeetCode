class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : changed) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int num : changed) {
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) - 1);
                if (freq.get(num) == 0) {
                    freq.remove(num);
                }
                int twiceNum = 2 * num;
                if (freq.containsKey(twiceNum)) {
                    freq.put(twiceNum, freq.get(twiceNum) - 1);
                    if (freq.get(twiceNum) == 0) {
                        freq.remove(twiceNum);
                    }
                    ans.add(num);
                } else {
                    return new int[]{};
                }
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i<ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}