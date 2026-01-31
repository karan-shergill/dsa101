// https://leetcode.com/problems/minimum-path-sum/description/

// RECURSIVE
class Solution {
    public int minPathSum(int[][] grid) {
        return minPathSum(grid, 0, 0);
    }

    private int minPathSum(int[][] grid, int row, int col) {
        int ROW = grid.length;
        int COL = grid[0].length;

        if (row == ROW-1 && col == COL-1) {
            return grid[row][col];
        }

        if (row >= ROW || col >= COL) {
            return Integer.MAX_VALUE;
        }

        // move right
        int moveRight = minPathSum(grid, row, col + 1);
        moveRight = moveRight == Integer.MAX_VALUE ? Integer.MAX_VALUE : moveRight + grid[row][col];

        // move left
        int moveBottom = minPathSum(grid, row + 1, col);
        moveBottom = moveBottom == Integer.MAX_VALUE ? Integer.MAX_VALUE : moveBottom + grid[row][col];

        return Math.min(moveRight, moveBottom);
    }
}

// TOP-DOWN
class Solution {
    public int minPathSum(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;

        int[][] cache = new int[ROW][COL];

        for (int i=0; i<ROW; i++) {
            Arrays.fill(cache[i], -1);
        }
        return minPathSum(grid, 0, 0, cache);
    }

    private int minPathSum(int[][] grid, int row, int col, int[][] cache) {
        int ROW = grid.length;
        int COL = grid[0].length;

        if (row == ROW-1 && col == COL-1) {
            return grid[row][col];
        }

        if (row >= ROW || col >= COL) {
            return Integer.MAX_VALUE;
        }

        if (cache[row][col] != -1) {
            return cache[row][col];
        }

        // move right
        int moveRight = minPathSum(grid, row, col + 1, cache);
        moveRight = moveRight == Integer.MAX_VALUE ? Integer.MAX_VALUE : moveRight + grid[row][col];

        // move left
        int moveBottom = minPathSum(grid, row + 1, col, cache);
        moveBottom = moveBottom == Integer.MAX_VALUE ? Integer.MAX_VALUE : moveBottom + grid[row][col];

        cache[row][col] = Math.min(moveRight, moveBottom);
        return cache[row][col];
    }
}
