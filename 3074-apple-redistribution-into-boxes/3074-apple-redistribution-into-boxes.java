class Solution {
    public int minimumBoxes(int[] apple, int[] cap) {
        int totalApps = 0;

        for (int apps : apple) {
            totalApps += apps;
        }

        sortReverse(cap);

        int idx = 0, ans = 0;
        while (totalApps > 0) {
            totalApps -= cap[idx++];
            ans++;
        }


        return ans;
    }


    void sortReverse(int[] cap) {
        Arrays.sort(cap);
        int start = 0, end = cap.length-1;

        while (start < end) {
            int temp = cap[start];
            cap[start] = cap[end];
            cap[end] = temp;
            start++;
            end--;
        }
    }
}