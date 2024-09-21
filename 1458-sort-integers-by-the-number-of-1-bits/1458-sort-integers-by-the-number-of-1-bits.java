class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] num = new Integer[n];

        for (int i = 0; i<n; i++) {
            num[i] = arr[i];
        }

        Comparator comp = new CustomComparator();
        Arrays.sort(num, comp);

        for (int i = 0; i<n; i++) {
            arr[i] = num[i];
        }

        return arr;
    }
}

class CustomComparator implements Comparator<Integer>{
    public int compare(Integer a, Integer b) {
        if (Integer.bitCount(a) == Integer.bitCount(b)) {
            return a - b;
        }

        return Integer.bitCount(a) - Integer.bitCount(b);
    }
}