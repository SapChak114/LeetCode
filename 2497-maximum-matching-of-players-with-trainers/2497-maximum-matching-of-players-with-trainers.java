class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int n = players.length, m = trainers.length;
        int count = 0, j = 0;
        for (int i = 0; i<n; i++) {
            while (j < m && players[i] > trainers[j]) {
                j++;
            }
            if (j == m) {
                break;
            }

            if (players[i] <= trainers[j]) {
                count++;
                j++;
            }
        }

        return count;
    }
}