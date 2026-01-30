// https://leetcode.com/problems/unique-paths-ii/description/

// RECURSIVE
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int ROW = obstacleGrid.length;
        int COL = obstacleGrid[0].length;

        // BASE CASE: last index has 1
        if (obstacleGrid[ROW-1][COL-1] == 1) {
            return 0;
        }

        return uniquePathsWithObstacles(obstacleGrid, 0, 0);
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int row, int col) {
        int ROW = obstacleGrid.length;
        int COL = obstacleGrid[0].length;

        // BASE CASE: we reched last index
        if (row == ROW-1 && col == COL-1) {
            return 1;
        }

        // BASE CASE: out of range row and col
        if (row >= ROW || col >= COL) {
            return 0;
        }

        // BASE CASE: not possible to move from this cell
        if (obstacleGrid[row][col] == 1) {
            return 0;
        }

        int moveRight = uniquePathsWithObstacles(obstacleGrid, row, col + 1);
        int moveBottom = uniquePathsWithObstacles(obstacleGrid, row + 1, col);

        return moveRight + moveBottom;
    }
}

// TOP-DOWN
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int ROW = obstacleGrid.length;
        int COL = obstacleGrid[0].length;

        // BASE CASE: last index has 1
        if (obstacleGrid[ROW-1][COL-1] == 1) {
            return 0;
        }

        int[][] cache = new int[ROW+1][COL+1];
        for (int i=0; i<=ROW; i++) {
            Arrays.fill(cache[i], -1);
        }

        return uniquePathsWithObstacles(obstacleGrid, 0, 0, cache);
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int row, int col, int[][] cache) {
        int ROW = obstacleGrid.length;
        int COL = obstacleGrid[0].length;

        // BASE CASE: we reched last index
        if (row == ROW-1 && col == COL-1) {
            return 1;
        }

        // BASE CASE: out of range row and col
        if (row >= ROW || col >= COL) {
            return 0;
        }

        // BASE CASE: not possible to move from this cell
        if (obstacleGrid[row][col] == 1) {
            return 0;
        }


        if (cache[row][col] != -1) {
            return cache[row][col];
        }

        int moveRight = uniquePathsWithObstacles(obstacleGrid, row, col + 1, cache);
        int moveBottom = uniquePathsWithObstacles(obstacleGrid, row + 1, col, cache);

        cache[row][col] = moveRight + moveBottom;
        return cache[row][col];
    }
}
