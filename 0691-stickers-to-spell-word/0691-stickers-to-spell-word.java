class Solution {
    List<Map<Character, Integer>> stickerCount;
    Map<String, Integer> dp;

    public int minStickers(String[] stickers, String target) {
        stickerCount = new ArrayList<>();
        dp = new HashMap<>();

        for (String st : stickers) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : st.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            stickerCount.add(map);
        }

        dp.put("", 0);
        int res = dfs(target);

        return res != (int)1e9 + 7 ? res : -1;
    }

    int dfs(String t) {
        if (dp.containsKey(t)) {
            return dp.get(t);
        }

        int res = (int)1e9 + 7;
        for (Map<Character, Integer> st : stickerCount) {
            if (!st.containsKey(t.charAt(0))) {
                continue;
            }

            StringBuilder rem = new StringBuilder();
            Map<Character, Integer> cpSt = new HashMap<>(st);

            for (char c : t.toCharArray()) {
                if (cpSt.getOrDefault(c, 0) > 0) {
                    cpSt.put(c, cpSt.get(c) - 1);
                } else {
                    rem.append(c);
                }
            }

            if (rem.length() != 0) {
                res = Math.min(res, 1 + dfs(rem.toString()));
            } else {
                res = Math.min(res, 1);
            }
        }

        dp.put(t, res);
        return res;
    }
}