// https://leetcode.com/problems/house-robber/description/

// RECURSIVE
class Solution {
    public int rob(int[] houses) {
        return rob(houses, houses.length - 1);
    }

    private int rob(int[] houses, int currHouseNo) {
        // BASE CASE: can't be robbed
        if (currHouseNo < 0) {
            return 0;
        }

        // case 1: don't rob curr house -> move to next house
        int dontRobCurrHouse = rob(houses, currHouseNo - 1);

        // case 2: rob curr house -> move to next to next house
        int robCurrHouse = rob(houses, currHouseNo - 2) + houses[currHouseNo];

        // we need to return max robbed amount
        return Math.max(dontRobCurrHouse, robCurrHouse);
    }
}

// TOP DOWN
class Solution {
    public int rob(int[] houses) {
        int[] cache = new int[houses.length + 1];
        Arrays.fill(cache, -1);
        return rob(houses, houses.length - 1, cache);
    }

    private int rob(int[] houses, int currHouseNo, int[] cache) {
        // BASE CASE: can't be robbed
        if (currHouseNo < 0) {
            return 0;
        }

        if (cache[currHouseNo] != -1) {
            return cache[currHouseNo];
        }

        // case 1: don't rob curr house -> move to next house
        int dontRobCurrHouse = rob(houses, currHouseNo - 1, cache);

        // case 2: rob curr house -> move to next to next house
        int robCurrHouse = rob(houses, currHouseNo - 2, cache) + houses[currHouseNo];

        // we need to return max robbed amount
        cache[currHouseNo] = Math.max(dontRobCurrHouse, robCurrHouse);
        return cache[currHouseNo];
    }
}
