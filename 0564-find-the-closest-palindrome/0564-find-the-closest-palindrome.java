class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        int mid = len%2 == 0 ? len/2 - 1 : len/2;
        long half = Long.parseLong(n.substring(0, mid+1));

        List<Long> candidates = new ArrayList<>();
        candidates.add(findPallindrome(half, len%2 == 1));
        candidates.add(findPallindrome(half+1l, len%2 == 1));
        candidates.add(findPallindrome(half-1l, len%2 == 1));
        candidates.add((long) (Math.pow(10l, len) + 1l));
        candidates.add((long) (Math.pow(10l, len - 1l) - 1l));

        long ans = 0, diff = Long.MAX_VALUE, nl = Long.parseLong(n);
        for (long candidate : candidates) {
            if (candidate == nl) {
                continue;
            } else if (Math.abs(candidate - nl) < diff) {
                diff = Math.abs(candidate - nl);
                ans = candidate;
            } else if (Math.abs(candidate - nl) == diff) {
                ans = Math.min(ans, candidate);
            }
        }

        return String.valueOf(ans);
    }

    long findPallindrome(long leftPart, boolean isOdd) {
        long fullNum = leftPart;

        if (isOdd) {
            leftPart /= 10;
        }

        while (leftPart > 0) {
            fullNum = fullNum * 10 + (leftPart % 10);
            leftPart /= 10;
        }

        return fullNum;
    }
}