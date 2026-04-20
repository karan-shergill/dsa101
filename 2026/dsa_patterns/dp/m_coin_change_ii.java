// https://leetcode.com/problems/coin-change-ii/description/

// RECURSIVE
class Solution {
    public int change(int amount, int[] coins) {
        return change(amount, coins, 0);
    }

    private int change(int amount, int[] coins, int currIndex) {
        if (amount == 0) {
            return 1;
        }

        if (currIndex == coins.length) {
            return 0;
        }

        int take = 0;
        if (amount >= coins[currIndex]) {
            take = change(amount - coins[currIndex], coins, currIndex);
        }
        int dontTake = change(amount, coins, currIndex + 1);

        return take + dontTake;
    }
}

// TOP-DOWN
class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] cache = new Integer[amount+1][coins.length];
        return change(amount, coins, 0, cache);
    }

    private int change(int amount, int[] coins, int currIndex, Integer[][] cache) {
        if (amount == 0) {
            return 1;
        }

        if (currIndex == coins.length) {
            return 0;
        }

        if (cache[amount][currIndex] != null) {
            return cache[amount][currIndex];
        }

        int take = 0;
        if (amount >= coins[currIndex]) {
            take = change(amount - coins[currIndex], coins, currIndex, cache);
        }
        int dontTake = change(amount, coins, currIndex + 1, cache);

        cache[amount][currIndex] = take + dontTake;
        return cache[amount][currIndex];
    }
}
