class Solution {
    public int snakesAndLadders(int[][] board) {
        List<Integer> flatBoard = new ArrayList<>();
        Map<Integer, Integer> ladderOrSnake = new HashMap<>();
        int n = board.length, m = board[0].length;
        
        for (int i = n-1; i>=0; i--) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j<m; j++) {
                row.add(board[i][j]);
            }
            
            if ((n - i - 1) % 2 == 1) {
                Collections.reverse(row);
            }
            
            flatBoard.addAll(row);
        }
        
        for (int i = 0; i<flatBoard.size(); i++) {
            if (flatBoard.get(i) != -1) {
                ladderOrSnake.put(i+1, flatBoard.get(i));
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        Set<Integer> vis = new HashSet<>();
        vis.add(1);
        
        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            int pos = val[0];
            int move = val[1];
            
            if (pos == n*n) {
                return move;
            }
            
            for (int i = 1; i<=6; i++) {
                int newPos = pos + i;
                
                if (newPos > n*n) {
                    break;
                }
                
                if (ladderOrSnake.containsKey(newPos)) {
                    newPos = ladderOrSnake.get(newPos);
                }
                
                if (!vis.contains(newPos)) {
                    vis.add(newPos);
                    queue.add(new int[]{newPos, move+1});
                }
            }
        }
        
        return -1;
    }
}