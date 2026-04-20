// https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1

// RECURSION
class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        return knapsack(capacity, val, wt, 0);
        
    }

    private int knapsack(int W, int[] val, int[] wt, int currIndex) {
        if (currIndex == wt.length) {
            return 0;
        }

        int pick = 0;
        if (W >= wt[currIndex]) {
            pick = knapsack(W - wt[currIndex], val, wt, currIndex) + val[currIndex];
        }

        int dontPick = knapsack(W, val, wt, currIndex + 1);

        return Math.max(pick, dontPick);
    }
}

// TOP-DOWN
class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        Integer[][] cache = new Integer[capacity+1][wt.length];
        return knapsack(capacity, val, wt, 0, cache);
    }

    private int knapsack(int W, int[] val, int[] wt, int currIndex, Integer[][] cache) {
        if (currIndex == wt.length) {
            return 0;
        }

        if (cache[W][currIndex] != null) {
            return cache[W][currIndex];
        }

        int pick = 0;
        if (W >= wt[currIndex]) {
            pick = knapsack(W - wt[currIndex], val, wt, currIndex, cache) + val[currIndex];
        }

        int dontPick = knapsack(W, val, wt, currIndex + 1, cache);

        cache[W][currIndex] = Math.max(pick, dontPick);
        return cache[W][currIndex];
    }
}
