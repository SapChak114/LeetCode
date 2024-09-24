class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] res = new Integer[n];
        for (int i = 0; i<n; i++) {
            res[i] = arr[i];
        }

        Comparator comp = new CustomComparator();
        Arrays.sort(res, comp);

        for (int i = 0; i<n; i++) {
            arr[i] = res[i];
        }

        return arr;
    }
}

class CustomComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer a, Integer b) {
        if (Integer.bitCount(a) == Integer.bitCount(b)) {
            return a-b;
        }

        return Integer.bitCount(a) - Integer.bitCount(b);
    }
}