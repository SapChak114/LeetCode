class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        ans.add(new ArrayList<>(List.of(1)));
        if (numRows > 1) {
            ans.add(new ArrayList<>(List.of(1,1)));
        }

        for (int i = 1; i<numRows-1; i++) {
            ans.add(new ArrayList<>(List.of(1)));
            for (int j = 0; j<ans.get(i).size()-1; j++) {
                int sum = ans.get(i).get(j) + ans.get(i).get(j+1);
                ans.get(i+1).add(sum);
            }
            ans.get(i+1).add(1);
        }

        return ans;
    }
}