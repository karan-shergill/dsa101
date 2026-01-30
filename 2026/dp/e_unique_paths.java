// https://leetcode.com/problems/unique-paths/description/

// RECURSIVE
class Solution {
    public int uniquePaths(int m, int n) {
        return countUniquePaths(m, n, 0, 0);
    }

    private int countUniquePaths(int m, int n, int row, int col) {
        // BASE CASE: we have reached the last box (m-1, n-1)
        if (row == m-1 && col == n-1) {
            // count as one path
            return 1;
        }

        // BASE CASE: out of bound for row and col
        if (row >= m || col >= n) {
            return 0;
        }

        // move right
        int moveRight = countUniquePaths(m, n, row, col + 1);

        // move down
        int moveBottom = countUniquePaths(m, n, row + 1, col);

        return moveRight + moveBottom;
    }
}

// TOP-DOWN
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m+1][n+1];
        for (int i=0; i<=m; i++) {
            Arrays.fill(cache[i], -1);
        }
        return countUniquePaths(m, n, 0, 0, cache);
    }

    private int countUniquePaths(int m, int n, int row, int col, int[][] cache) {
        // BASE CASE: we have reached the last box (m-1, n-1)
        if (row == m-1 && col == n-1) {
            // count as one path
            return 1;
        }

        // BASE CASE: out of bound for row and col
        if (row >= m || col >= n) {
            return 0;
        }

        if (cache[row][col] != -1) {
            return cache[row][col];
        }

        // move right
        int moveRight = countUniquePaths(m, n, row, col + 1, cache);

        // move down
        int moveBottom = countUniquePaths(m, n, row + 1, col, cache);

        cache[row][col] = moveRight + moveBottom;
        return cache[row][col];
    }
}
