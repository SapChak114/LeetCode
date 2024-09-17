class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] vals = new Integer[n];
        for (int i = 0; i<n; i++) {
            vals[i] = arr[i];
        }

        Comparator<Integer> comp = new CustomComparator();
        Arrays.sort(vals, comp);

        for (int i = 0; i<n; i++) {
            arr[i] = vals[i];
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