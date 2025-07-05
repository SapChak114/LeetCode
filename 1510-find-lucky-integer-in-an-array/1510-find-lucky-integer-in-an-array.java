class Solution {
    public int findLucky(int[] arr) {
        TreeMap<Integer, Integer> freq = new TreeMap<>(Collections.reverseOrder());

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() == e.getKey()) {
                return e.getKey();
            }
        }

        return -1;
    }
}