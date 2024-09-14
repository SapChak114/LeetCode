class Solution {
    List<Map<Character, Integer>> stickerList;
    Map<String, Integer> dp;
    public int minStickers(String[] stickers, String target) {
        this.stickerList = new ArrayList<>();
        this.dp = new HashMap<>();

        for (String st : stickers) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : st.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            this.stickerList.add(map);
        }
        dp.put("", 0);

        int res = dfs(target);
        return res != (int)1e9 + 7 ? res : -1;
    }

    int dfs (String t) {
        if (dp.containsKey(t)) {
            return dp.get(t);
        }

        int res = (int)1e9 + 7;

        for (Map<Character, Integer> st : stickerList) {
            if (!st.containsKey(t.charAt(0))) {
                continue;
            }

            Map<Character, Integer> cpSt = new HashMap<>(st);
            StringBuilder rem = new StringBuilder();
            
            for (int i = 0; i<t.length(); i++) {
                if (cpSt.getOrDefault(t.charAt(i), 0) > 0) {
                    cpSt.put(t.charAt(i), cpSt.get(t.charAt(i)) - 1);
                } else {
                    rem.append(t.charAt(i));
                }
            }

            if (rem.length() > 0) {
                res = Math.min(res, 1 + dfs(rem.toString()));
            } else {
                res = Math.min(res, 1);
            }
        }
        
        dp.put(t, res);
        return res;
    }
}