class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (isPred(words[i], words[j])) {
                    adjList[i].add(j);
                }
            }
        }

        int maxchain = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] inDeg = new int[n];

        for (int i = 0; i<n; i++) {
            for (int next : adjList[i]) {
                inDeg[next]++;
            }
        }

        for (int i = 0; i<n; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }

        int maxChain = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            maxChain++;
            for (int i = 0; i<size; i++) {
                int node = queue.poll();
                for (int next : adjList[node]) {
                    inDeg[next]--;
                    if (inDeg[next] == 0) {
                        queue.add(next);
                    }
                }
            }
        }

        return maxChain;
    }

    boolean isPred(String srcWord, String destWord) {
        int n = srcWord.length(), m = destWord.length();

        if ((m - n) != 1) {
            return false;
        }

        return isSubseq(srcWord, destWord);
    }

    boolean isSubseq(String w1, String w2) {
        int n = w1.length(), m = w2.length(), j = 0;
        char[] ch1 = w1.toCharArray(), ch2 = w2.toCharArray();

        for (int i = 0; i<m; i++) {
            if (j < n && (ch1[j] == ch2[i])) {
                j++;
            }
        }

        return j == n;
    }
}