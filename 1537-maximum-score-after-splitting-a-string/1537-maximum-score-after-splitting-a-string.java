class Solution {
    public int maxScore(String s) {
        char[] ch = s.toCharArray();
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i<ch.length; i++) {
            nums.add(ch[i]-'0');
        }

        int[] pfOnes = new int[nums.size()];
        int[] pfZeros = new int[nums.size()];

        int n = pfOnes.length;
        if (nums.get(0) == 0) {
            pfZeros[0] = 1;
        }

        if (nums.get(0) == 1) {
            pfOnes[0] = 1;
        }

        for (int i = 1; i<n; i++) {
            if (nums.get(i) == 1) {
                pfOnes[i] = pfOnes[i-1] + 1;
                pfZeros[i] = pfZeros[i-1];
            } else {
                pfZeros[i] = pfZeros[i-1] + 1;
                pfOnes[i] = pfOnes[i-1];
            }
        }

        int ans = 0;
        for (int i = 0; i<n-1; i++) {
            int left = pfZeros[i];
            int right = pfOnes[n-1] - pfOnes[i];
            int sum =  left + right;
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}