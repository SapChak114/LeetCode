class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        List<Integer> flatBoard = new ArrayList<>();
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

        Map<Integer, Integer> snakeOrLadder = new HashMap<>();
        
        for (int i = 0; i<flatBoard.size(); i++) {
            if (flatBoard.get(i) != -1) {
                snakeOrLadder.put(i + 1, flatBoard.get(i));
            }
        }

        Queue<int[]> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add(new int[]{1, 0});
        vis.add(1);

        while (!q.isEmpty()) {
            int[] vals = q.poll();
            int pos = vals[0];
            int totalDiceRolls = vals[1];
            
            if (pos == n * n) {
                return totalDiceRolls;
            }

            for (int i = 1; i<=6; i++) {
                int newPos = pos + i;

                if (newPos > n * n) {
                    break;
                }

                if (snakeOrLadder.containsKey(newPos)) {
                    newPos = snakeOrLadder.get(newPos);
                }

                if (!vis.contains(newPos)) {
                    vis.add(newPos);
                    q.add(new int[]{newPos, totalDiceRolls + 1});
                }
            }
        }

        return -1;
    }
}