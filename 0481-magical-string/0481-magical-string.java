class Solution {
    public int magicalString(int n) {
        if (n <= 3) {
            return 1;
        }

        Queue<Integer> q = new LinkedList<>();
        int totalCount = 1, currDigit = 1;
        q.add(2);

        for (int i = 2; i<n; i++) {
            int currCount = q.poll();

            for (int j = 0; j<currCount; j++) {
                q.add(currDigit);
            }

            if (currCount == 1) {
                totalCount++;
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