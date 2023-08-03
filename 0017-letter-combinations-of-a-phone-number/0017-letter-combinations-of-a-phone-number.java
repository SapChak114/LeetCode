class Solution {
    List<String> ls;
    Map<Character,String> map;
    char[] ch;
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        ls = new ArrayList<>();
        
        map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        ch = digits.toCharArray();
        dfs(0,"");
        return ls;
    }
    
    void dfs(int i, String combi){
        if(i==ch.length){
            ls.add(combi);
            return;
        }
        
        for(char c : map.get(ch[i]).toCharArray()) dfs(i+1,combi+""+c);
    }
    
}