// https://leetcode.com/problems/maximum-number-of-points-with-cost/description/

// RECURSIVE
class Solution {
    public long maxPoints(int[][] points) {
        return maxPoints(points, 0, -1);
    }

    public long maxPoints(int[][] points, int currRow, int lastCol) {
        int ROW = points.length;
        int COL = points[0].length;

        if (currRow >= ROW) {
            return 0;
        }

        long maxPointsGot = Long.MIN_VALUE;
        for (int currCol = 0; currCol<COL; currCol++) {
            long currLevelPoint = (long)points[currRow][currCol];
            if (lastCol != -1) {
                currLevelPoint -= Math.abs(lastCol - currCol);
            } 
            long pointsFromThisChoice = maxPoints(points, currRow+1, currCol) + currLevelPoint;
            maxPointsGot = Math.max(maxPointsGot, pointsFromThisChoice);
        }

        return maxPointsGot;
    }
}

// TOP-DOWN
class Solution {

    public long maxPoints(int[][] points) {
        int ROW = points.length;
        int COL = points[0].length;

        long[][] cache = new long[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            Arrays.fill(cache[i], -1);
        }
        return maxPoints(points, 0, -1, cache);
    }

    public long maxPoints(int[][] points, int currRow, int lastCol, long[][] cache) {
        int ROW = points.length;
        int COL = points[0].length;

        if (currRow >= ROW) {
            return 0;
        }

        if (lastCol != -1 && cache[currRow][lastCol] != -1) {
            return cache[currRow][lastCol];
        }

        long maxPointsGot = Long.MIN_VALUE;
        for (int currCol = 0; currCol < COL; currCol++) {
            long currLevelPoint = (long) points[currRow][currCol];
            if (lastCol != -1) {
                currLevelPoint -= Math.abs(lastCol - currCol);
            }
            long pointsFromThisChoice = maxPoints(points, currRow + 1, currCol, cache) + currLevelPoint;
            maxPointsGot = Math.max(maxPointsGot, pointsFromThisChoice);
        }

        if (lastCol != -1) {
            cache[currRow][lastCol] = maxPointsGot;
        }

        return maxPointsGot;
    }
}
