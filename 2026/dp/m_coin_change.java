// https://leetcode.com/problems/coin-change/description/

// RECURSIVE
class Solution {

    public int coinChange(int[] coins, int amount) {
        int count = coinChange(coins, amount, coins.length - 1);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private int coinChange(int[] coins, int amount, int index) {
        // base case 1
        if (amount == 0) {
            return 0;
        }
        // base case 2
        if (amount > 0 && index < 0) {
            return Integer.MAX_VALUE;
        }

        int takeCurrentCoin = Integer.MAX_VALUE;
        if (amount >= coins[index]) {
            // take current coin
            int subResult = coinChange(coins, amount - coins[index], index);
            if (subResult != Integer.MAX_VALUE) {
                takeCurrentCoin = 1 + subResult;
            }
        }
        // don't take current coin
        int dontTakeCurrentCoin = coinChange(coins, amount, index - 1);

        return Math.min(takeCurrentCoin, dontTakeCurrentCoin);
    }
}

// TOP DOWN
class Solution {

    public int coinChange(int[] coins, int amount) {
        int [][] cache = new int[coins.length + 1][amount + 1];
        for (int i=0; i<coins.length; i++) {
            Arrays.fill(cache[i], -1);
        }

        int count = coinChange(coins, amount, coins.length - 1, cache);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private int coinChange(int[] coins, int amount, int index, int[][] cache) {
        // base case 1
        if (amount == 0) {
            return 0;
        }
        // base case 2
        if (amount > 0 && index < 0) {
            return Integer.MAX_VALUE;
        }

        if (cache[index][amount] != -1) {
            return cache[index][amount];
        }

        int takeCurrentCoin = Integer.MAX_VALUE;
        if (amount >= coins[index]) {
            // take current coin
            int subResult = coinChange(coins, amount - coins[index], index, cache);
            if (subResult != Integer.MAX_VALUE) {
                takeCurrentCoin = 1 + subResult;
            }
        }
        // don't take current coin
        int dontTakeCurrentCoin = coinChange(coins, amount, index - 1, cache);

        cache[index][amount] = Math.min(takeCurrentCoin, dontTakeCurrentCoin);
        return cache[index][amount];
    }
}
