class Solution {
    public String[] findRelativeRanks(int[] score) {
        List<Pair<Integer,Integer>> list = new ArrayList<>();
        for (int i = 0; i<score.length; i++) {
            Pair p = new Pair(score[i], i);
            list.add(p);
        }

        list.sort(
            Comparator.comparing((Pair p) -> (int) p.getKey(), Comparator.reverseOrder()) // Descending order for keys
              .thenComparing((Pair p) -> (int) p.getValue())                      // Ascending order for values
        );



        String[] ans = new String[list.size()];

        for (int i = 0; i<ans.length; i++) {
            if (i == 0) {
                ans[list.get(i).getValue()] = "Gold Medal";
            } else if (i == 1) {
                ans[list.get(i).getValue()] = "Silver Medal";
            } else if (i == 2) {
                ans[list.get(i).getValue()] = "Bronze Medal";
            } else {
                ans[list.get(i).getValue()] = Integer.toString(i + 1);
            }
        }

        return ans;
    }
}