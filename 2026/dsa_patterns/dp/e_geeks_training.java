// https://www.geeksforgeeks.org/problems/geeks-training/0

// RECURSIVE
class Solution {
    public int maximumPoints(int mat[][]) {
        // 0-Running, 1-Fighting, 2-Learning
        return maximumPoints(mat, 0, -1);
    }

    private int maximumPoints(int[][] mat, int row, int last) {
        if (row >= mat.length) {
            return 0;
        }

        int maxPoint = Integer.MIN_VALUE;
        for (int i=0; i<mat[0].length; i++) {
            if (i != last) {
                int currPoints = maximumPoints(mat, row + 1, i) + mat[row][i]; 
                maxPoint = Math.max(maxPoint, currPoints);
            }
        }

        return maxPoint;
    }
}

// TOP DOWN
class Solution {
    public int maximumPoints(int mat[][]) {
        // 0-Running, 1-Fighting, 2-Learning
        int[][] cache = new int[mat.length + 1][4];
        for (int i=0; i<=mat.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return maximumPoints(mat, 0, 3, cache);
    }

    private int maximumPoints(int[][] mat, int row, int last, int[][] cache) {
        if (row >= mat.length) {
            return 0;
        }

        if (cache[row][last] != -1) {
            return cache[row][last];
        }

        int maxPoint = Integer.MIN_VALUE;
        for (int i=0; i<mat[0].length; i++) {
            if (i != last) {
                int currPoints = maximumPoints(mat, row + 1, i, cache) + mat[row][i]; 
                maxPoint = Math.max(maxPoint, currPoints);
            }
        }

        cache[row][last] = maxPoint;
        return cache[row][last];
    }
}
