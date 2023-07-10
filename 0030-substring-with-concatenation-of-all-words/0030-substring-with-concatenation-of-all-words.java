public class Solution {
    public boolean isPresent(String bigWord, Map<String, Integer> counterd, int length) {
        int n = bigWord.length();
        Map<String, Integer> counterb = new HashMap<>();

        for (int start = 0; start < n; start += length) {
            String word = bigWord.substring(start, start + length);
            counterb.put(word, counterb.getOrDefault(word, 0) + 1);
        }

        return counterb.equals(counterd);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int bigLength = 0;
        for (String word : words) {
            bigLength += word.length();
        }
        int length = words[0].length();
        int n = s.length();
        Map<String, Integer> counterd = new HashMap<>();
        for (String word : words) {
            counterd.put(word, counterd.getOrDefault(word, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i + bigLength > n) {
                break;
            }
            String bigWord = s.substring(i, i + bigLength);

            if (isPresent(bigWord, counterd, length)) {
                ans.add(i);
            }
        }

        return ans;
    }
}