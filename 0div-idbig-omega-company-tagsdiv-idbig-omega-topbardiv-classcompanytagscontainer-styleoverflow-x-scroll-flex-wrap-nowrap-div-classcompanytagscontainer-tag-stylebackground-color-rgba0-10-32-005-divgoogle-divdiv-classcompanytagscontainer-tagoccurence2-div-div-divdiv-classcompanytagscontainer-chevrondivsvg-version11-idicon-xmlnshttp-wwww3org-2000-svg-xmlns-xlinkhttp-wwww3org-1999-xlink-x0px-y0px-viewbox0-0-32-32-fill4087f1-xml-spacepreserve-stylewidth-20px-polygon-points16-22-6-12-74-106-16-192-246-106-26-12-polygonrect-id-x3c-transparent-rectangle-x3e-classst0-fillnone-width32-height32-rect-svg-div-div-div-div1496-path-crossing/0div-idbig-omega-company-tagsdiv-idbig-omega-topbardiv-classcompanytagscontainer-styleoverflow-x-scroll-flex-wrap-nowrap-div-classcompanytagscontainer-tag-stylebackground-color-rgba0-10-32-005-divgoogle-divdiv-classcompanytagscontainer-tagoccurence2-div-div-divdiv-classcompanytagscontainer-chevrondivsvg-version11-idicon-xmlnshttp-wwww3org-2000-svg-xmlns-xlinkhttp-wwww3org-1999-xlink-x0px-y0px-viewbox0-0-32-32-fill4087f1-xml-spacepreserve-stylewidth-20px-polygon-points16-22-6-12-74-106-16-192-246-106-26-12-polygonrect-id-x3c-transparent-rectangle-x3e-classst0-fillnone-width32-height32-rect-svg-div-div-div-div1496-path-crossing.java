class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Solution {
    public boolean isPathCrossing(String path) {
        char[] ch = path.toCharArray();
        Set<Pair> set = new HashSet<>();
        
        int x = 0, y = 0;
        set.add(new Pair(x,y));
        
        for (char c : ch) {
            if (c == 'N') x++;
            else if (c == 'E') y++;
            else if (c == 'W') y--;
            else x--;
            Pair p = new Pair(x, y);
            if (set.contains(p)) return true;
            else set.add(p);
        }

        return false;
    }
}
