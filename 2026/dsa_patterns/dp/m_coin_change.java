// https://leetcode.com/problems/coin-change/description/

// RECURSIVE
class Solution {
    public int coinChange(int[] coins, int amount) {
        int count = coinChange(coins, amount, 0);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private int coinChange(int[] coins, int amount, int currIndex) {
        if (amount == 0) {
            return 0;
        }

        if (currIndex >= coins.length) {
            return Integer.MAX_VALUE;
        }

        int pick = Integer.MAX_VALUE;
        if (amount >= coins[currIndex]) {
            pick = coinChange(coins, amount - coins[currIndex], currIndex);
            if (pick != Integer.MAX_VALUE) {
                pick += 1;
            }
        }

        int dontPick = coinChange(coins, amount, currIndex + 1);

        return Math.min(pick, dontPick);
    }
}

// TOP DOWN
class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[][] cache = new Integer[amount + 1][coins.length];
        int count = coinChange(coins, amount, 0, cache);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private int coinChange(int[] coins, int amount, int currIndex, Integer[][] cache) {
        if (amount == 0) {
            return 0;
        }

        if (currIndex >= coins.length) {
            return Integer.MAX_VALUE;
        }

        if (cache[amount][currIndex] != null) {
            return cache[amount][currIndex];
        }

        int pick = Integer.MAX_VALUE;
        if (amount >= coins[currIndex]) {
            pick = coinChange(coins, amount - coins[currIndex], currIndex, cache);
            if (pick != Integer.MAX_VALUE) {
                pick += 1;
            }
        }

        int dontPick = coinChange(coins, amount, currIndex + 1, cache);

        cache[amount][currIndex] = Math.min(pick, dontPick);
        return cache[amount][currIndex];
    }
}
