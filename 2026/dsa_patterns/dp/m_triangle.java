// https://leetcode.com/problems/triangle/description/

// RECURSIVE
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(triangle, 0, 0);
    }

    private int minimumTotal(List<List<Integer>> triangle, int level, int index) {
        if (level >= triangle.size()) {
            return 0;
        }
        
        // take index
        int takeIndex1 = minimumTotal(triangle, level + 1, index) + triangle.get(level).get(index);

        // take index + 1
        int takeIndex2 = minimumTotal(triangle, level + 1, index + 1) + triangle.get(level).get(index);

        return Math.min(takeIndex1, takeIndex2);
    }
}

// TOP-DOWN
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] cache = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i=0; i<cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return minimumTotal(triangle, 0, 0, cache);
    }

    private int minimumTotal(List<List<Integer>> triangle, int level, int index, int[][] cache) {
        if (level >= triangle.size()) {
            return 0;
        }

        if (cache[level][index] != -1) {
            return cache[level][index];
        }
        
        // take index
        int takeIndex1 = minimumTotal(triangle, level + 1, index, cache) + triangle.get(level).get(index);

        // take index + 1
        int takeIndex2 = minimumTotal(triangle, level + 1, index + 1, cache) + triangle.get(level).get(index);

        cache[level][index] = Math.min(takeIndex1, takeIndex2);
        return cache[level][index];
    }
}
