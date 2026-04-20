// https://leetcode.com/problems/min-cost-climbing-stairs/description/

// RECURSIVE
class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int noOfStairs = cost.length;
        return Math.min(minCostClimbingStairs(cost, noOfStairs - 1), minCostClimbingStairs(cost, noOfStairs - 2));
    }

    private int minCostClimbingStairs(int[] cost, int currStairs) {
        if (currStairs < 0) {
            return 0;
        }

        int take1Step = cost[currStairs] + minCostClimbingStairs(cost, currStairs - 1);
        int take2Step = cost[currStairs] + minCostClimbingStairs(cost, currStairs - 2);
        return Math.min(take1Step, take2Step);
    }
}

// MEMOIZATION 
class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int noOfStairs = cost.length;

        int[] cache = new int[noOfStairs + 1];
        Arrays.fill(cache, -1);

        return Math.min(minCostClimbingStairs(cost, noOfStairs - 1, cache), minCostClimbingStairs(cost, noOfStairs - 2, cache));
    }

    private int minCostClimbingStairs(int[] cost, int currStairs, int[] cache) {
        if (currStairs < 0) {
            return 0;
        }

        if (cache[currStairs] != -1) {
            return cache[currStairs];
        }

        int take1Step = cost[currStairs] + minCostClimbingStairs(cost, currStairs - 1, cache);
        int take2Step = cost[currStairs] + minCostClimbingStairs(cost, currStairs - 2, cache);
        cache[currStairs] = Math.min(take1Step, take2Step);

        return cache[currStairs];
    }
}
