class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = n > 0 ? grid[0].length : 0;
        int communicableServerCount = 0;


        for (int row = 0; row<n; row++) {
            for (int col = 0; col<m; col++) {
                if (grid[row][col] == 1) {
                    boolean canCommunicate = false;

                    for (int otherCol = 0; otherCol<m; otherCol++) {
                        if (otherCol != col && grid[row][otherCol] == 1) {
                            canCommunicate = true;
                            break;
                        }
                    }

                    if (canCommunicate) {
                        communicableServerCount++;
                    } else {
                        for (int otherRow = 0; otherRow<n; otherRow++) {
                            if (otherRow != row && grid[otherRow][col] == 1) {
                                canCommunicate = true;
                                break;
                            }
                        }

                        if (canCommunicate) {
                            communicableServerCount++;
                        }
                    }
                } 
            }
        }

        return communicableServerCount;
    }
}