class Solution {
    public int magicalString(int n) {
        if (n <= 3) {
            return 1;
        }

        Queue<Integer> q = new LinkedList<>();
        int totalCount = 1, currDigit = 1, i = 2;
        q.add(2);

        while (i < n-1) {
            int currCount = q.poll();

            for (int j = 0; j<currCount && i<n-1; j++) {
                q.add(currDigit);
                if (currDigit == 1) {
                    totalCount++;
                }
                i++;
            }

            

            if (currDigit == 1) {
                currDigit = 2;
            } else {
                currDigit = 1;
            }
        }

        return totalCount;
    }
}