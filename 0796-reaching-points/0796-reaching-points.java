class Solution {
    boolean res;
    int sx, sy;
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        this.res = false;
        this.sx = sx;
        this.sy = sy;
        return rec(tx, ty);
    }

    boolean rec(int x, int y) {
        if (x < sx || y < sy) {
            return false;
        }
        if (x == sx && y == sy) {
            return true;
        }

        if (x < y) {
            if (x == sx) {
                return (y - sy) % x == 0;
            }
            return rec(x, y % x);
        } else {
            if (y == sy) {
                return (x - sx) % y == 0;
            }
            return rec(x % y, y);
        }
    }

    
}