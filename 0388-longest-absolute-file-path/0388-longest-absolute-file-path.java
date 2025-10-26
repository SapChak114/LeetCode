class Solution {
    public int lengthLongestPath(String input) {
        int longest = 0;

        String[] lines = input.split("\n");
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (String line : lines) {
            String name = line.replaceAll("\t", "");
            int dist = line.length() - name.length();

            if (line.contains(".")) {
                longest = Math.max(longest, map.get(dist) + name.length());
            } else {
                map.put(dist + 1, map.get(dist) + name.length() + 1);
            }
        }
        return longest;
    }
}