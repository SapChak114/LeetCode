class Solution {
    public boolean isPathCrossing(String path) {
        char[] ch = path.toCharArray();
        Set<String> set = new HashSet<>();
        
        int x = 0, y = 0;
        set.add(x+"-"+y);
        
        for (char c : ch) {
            if (c == 'N') x++;
            else if (c == 'E') y++;
            else if (c == 'W') y--;
            else x--;
            if (set.contains(x+"-"+y)) return true;
            else set.add(x+"-"+y);
        }

        return false;
    }
}
