class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] ar = new Integer[arr.length];
        int n = arr.length;
        for (int i = 0; i<ar.length; i++) {
            ar[i] = arr[i];
        }

        Comparator c = new CusomComparator();
        Arrays.sort(ar, c);

        for(int i = 0; i<n; i++) {
            arr[i] = ar[i];
        }

        return arr;
    }
}

class CusomComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer a, Integer b) {
        if (Integer.bitCount(a) == Integer.bitCount(b)) {
            return a-b;
        }

        return Integer.bitCount(a) - Integer.bitCount(b);
    }
}