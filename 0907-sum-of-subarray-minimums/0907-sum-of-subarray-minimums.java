class Solution {
    int mod = (int)1e9 + 7;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] arrL = minSubLeft(arr);
        int[] arrR = minSubRight(arr);

        System.out.println(Arrays.toString(arrL));
        System.out.println(Arrays.toString(arrR));
        
        int[] res = new int[n];
        long sum = 0;

        for (int i = 0; i<n; i++) {
            long left = i - arrL[i];
            long right = arrR[i] - i;

            long totalWays = left * right;

            long totalSum = totalWays * arr[i];
            sum = (sum + totalSum) % mod;
        }

        return (int)sum;
    }

    int[] minSubLeft(int[] arr) {
        int n = arr.length;

        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i<n; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            
            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }

            st.push(i);
        }
        
        return res;
    }


    int[] minSubRight(int[] arr) {
        int n = arr.length;

        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n-1; i>=0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                res[i] = n;
            } else {
                res[i] = st.peek();
            }

            st.push(i);
        }
        
        return res;
    }
}