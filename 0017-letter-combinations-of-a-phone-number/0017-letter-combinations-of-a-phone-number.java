class Solution {
    Map<Character, String> map;
    List<String> ls;
    char[] ch;
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        this.map = new HashMap<>();

        this.map = new HashMap<>();
        this.map.put('2',"abc");
        this.map.put('3',"def");
        this.map.put('4',"ghi");
        this.map.put('5',"jkl");
        this.map.put('6',"mno");
        this.map.put('7',"pqrs");
        this.map.put('8',"tuv");
        this.map.put('9',"wxyz");

        this.ls = new ArrayList<>();
        this.ch = digits.toCharArray();

        dfs(0, "");

        return ls;
    }

    void dfs(int i, String res) {
        if (i == ch.length) {
            ls.add(res);
            return;
        }

        for (char c : map.get(ch[i]).toCharArray()) {
            dfs(i + 1, res+c);
        }
    }
}