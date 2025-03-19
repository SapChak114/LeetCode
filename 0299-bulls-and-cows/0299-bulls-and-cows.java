class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : secret.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }

        int n = secret.length();

        int bulls = 0;
        for (int i = 0; i<n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                freq.put(guess.charAt(i), freq.getOrDefault(guess.charAt(i), 0) - 1);
            }
        }

        int cows = 0;
        for (int i = 0; i<n; i++) {
            if (secret.charAt(i) != guess.charAt(i) && freq.containsKey(guess.charAt(i)) && freq.get(guess.charAt(i)) > 0) {
                cows++;
                freq.put(guess.charAt(i), freq.getOrDefault(guess.charAt(i), 0) - 1);
            }
        }

        return bulls+"A"+cows+"B";
    }
}