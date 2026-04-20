// https://leetcode.com/problems/cherry-pickup-ii/description/

// RECURSIVE
class Solution {
    public int cherryPickup(int[][] grid) {
        return cherryPickup(grid, 0, 0, 0, grid[0].length - 1);
    }

    private int cherryPickup(int[][] grid, int row1, int col1, int row2, int col2) {
        int ROW = grid.length;
        int COL = grid[0].length;

        if (row1 >= ROW || row2 >= ROW) {
            return 0;
        }

        if (col1 < 0 || col1 >= COL || col2 < 0 || col2 >= COL) {
            return Integer.MIN_VALUE;
        }

        int currLevelCherryPick = col1 == col2 ? grid[row1][col1] : grid[row1][col1] + grid[row2][col2];

        int maxValue = Integer.MIN_VALUE;
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
                int currValue = cherryPickup(grid, row1 + 1, col1 + i, row2 + 1, col2 + j);
                maxValue = Math.max(maxValue, currValue);
            }
        }

        return maxValue == Integer.MIN_VALUE ? maxValue : maxValue + currLevelCherryPick;
    }
}

// TOP-DOWN
class Solution {

    public int cherryPickup(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int[][][] cache = new int[ROW][COL][COL];

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                Arrays.fill(cache[i][j], -1);
            }
        }

        return cherryPickup(grid, 0, 0, grid[0].length - 1, cache);
    }

    private int cherryPickup(int[][] grid, int row, int col1, int col2, int[][][] cache) {
        int ROW = grid.length;
        int COL = grid[0].length;

        if (row >= ROW) {
            return 0;
        }

        if (col1 < 0 || col1 >= COL || col2 < 0 || col2 >= COL) {
            return Integer.MIN_VALUE;
        }

        if (cache[row][col1][col2] != -1) {
            return cache[row][col1][col2];
        }

        int currLevelCherryPick = col1 == col2 ? grid[row][col1] : grid[row][col1] + grid[row][col2];

        int maxValue = Integer.MIN_VALUE;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int currValue = cherryPickup(grid, row + 1, col1 + i, col2 + j, cache);
                maxValue = Math.max(maxValue, currValue);
            }
        }

        cache[row][col1][col2] = maxValue == Integer.MIN_VALUE ? maxValue : maxValue + currLevelCherryPick;
        return cache[row][col1][col2];
    }
}
