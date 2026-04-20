// https://www.geeksforgeeks.org/problems/geek-jump/1

// RECURSIVE
class Solution {
    int minCost(int[] height) {
        return minCostUtil(height, height.length - 1);
    }
    
    int minCostUtil(int[] height, int stair) {
        if (stair == 0) {
            return 0;
        }

        int take1Step = minCostUtil(height, stair - 1) + Math.abs(height[stair] - height[stair - 1]);
        int take2Step = Integer.MAX_VALUE;
        if (stair > 1) {
            take2Step = minCostUtil(height, stair - 2) + Math.abs(height[stair] - height[stair - 2]);
        }
        
        return Math.min(take1Step, take2Step);

    }
}

// TOP-DOWN DP
class Solution {
    int minCost(int[] height) {
        int[] cache = new int[height.length + 1];
        Arrays.fill(cache, -1);
        return minCostUtil(height, height.length - 1, cache);
    }
    
    int minCostUtil(int[] height, int stair, int[] cache) {
        if (stair == 0) {
            return 0;
        }

        if (cache[stair] != -1) {
            return cache[stair];
        }

        int take1Step = minCostUtil(height, stair - 1, cache) + Math.abs(height[stair] - height[stair - 1]);
        int take2Step = Integer.MAX_VALUE;
        if (stair > 1) {
            take2Step = minCostUtil(height, stair - 2, cache) + Math.abs(height[stair] - height[stair - 2]);
        }
        
        cache[stair] = Math.min(take1Step, take2Step);
        return cache[stair];
    }
}
