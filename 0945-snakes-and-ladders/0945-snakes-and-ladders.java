class Solution {
    public int snakesAndLadders(int[][] board) {
        Map<Integer, Integer> posMap = new HashMap<>();
        int n = board.length;
        int pos = 1;
        List<Integer> flatBoard = new ArrayList<>();

        for (int i = n-1; i>=0; i--) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j<n; j++) {
                row.add(board[i][j]);
            }

            System.out.println((n-i-1));
            if ((n - i - 1) % 2 == 1) {
                Collections.reverse(row);
            }

            flatBoard.addAll(row);
        }

        for (int i = 0; i<flatBoard.size(); i++) {
            if (flatBoard.get(i) != -1) {
                posMap.put(i+1, flatBoard.get(i));
            }
        }


        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[n * n + 1];
        q.add(new int[]{1, 0});
        vis[1] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currPos = curr[0];
            int moves = curr[1];

            if (currPos == n*n) {
                return moves;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int nextPos = currPos + dice;
                if (nextPos > n*n) {
                    break;
                }

                if (posMap.containsKey(nextPos)) {
                    nextPos = posMap.get(nextPos);
                }

                if (!vis[nextPos]) {
                    vis[nextPos] = true;
                    q.add(new int[]{nextPos, moves + 1});
                }
            }
        }

        return -1;
    }
}