class Solution {
    boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        List<Integer> pfSum = new ArrayList<>(Collections.nCopies(n + 1, 0));

        for (int i = 0; i<n; i++) {
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);

            if (isVowel(start) && isVowel(end)) {
                pfSum.set(i+1, 1 + pfSum.get(i));
            } else {
                pfSum.set(i+1, pfSum.get(i));
            }
        }

        int[] result = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            int count = pfSum.get(query[1] + 1) - pfSum.get(query[0]);
            result[idx++] = count;
        }

        return result;
    }
}