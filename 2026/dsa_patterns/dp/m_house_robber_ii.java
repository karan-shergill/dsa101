// https://leetcode.com/problems/house-robber-ii/description/

// RECURSIVE
class Solution {

    public int rob(int[] houses) {
        if (houses.length == 1) {
            return houses[0];
        }
        return Math.max(rob(houses, houses.length - 1, true), rob(houses, houses.length - 2, false));
    }

    private int rob(int[] houses, int currHouseNo, boolean firstHouse) {
        // BASE CASE: can't be robbed
        if (currHouseNo < 0) {
            return 0;
        }

        if (currHouseNo == 0) {
            if (firstHouse == false) return houses[currHouseNo]; else return 0;
        }

        // case 1: don't rob curr house -> move to next house
        int dontRobCurrHouse = rob(houses, currHouseNo - 1, firstHouse);

        // case 2: rob curr house -> move to next to next house
        int robCurrHouse = rob(houses, currHouseNo - 2, firstHouse) + houses[currHouseNo];

        // we need to return max robbed amount
        return Math.max(dontRobCurrHouse, robCurrHouse);
    }
}

// TOP-DOWN
class Solution {

    public int rob(int[] houses) {
        if (houses.length == 1) {
            return houses[0];
        }
        int[] cache = new int[houses.length + 1];
        Arrays.fill(cache, -1);
        int take1stHouse = rob(houses, houses.length - 1, true, cache);
        Arrays.fill(cache, -1);
        int dontTake1stHouse = rob(houses, houses.length - 2, false, cache);
        return Math.max(take1stHouse, dontTake1stHouse);
    }

    private int rob(int[] houses, int currHouseNo, boolean firstHouse, int[] cache) {
        // BASE CASE: can't be robbed
        if (currHouseNo < 0) {
            return 0;
        }

        if (currHouseNo == 0) {
            if (firstHouse == false) return houses[currHouseNo]; else return 0;
        }

        if (cache[currHouseNo] != -1) {
            return cache[currHouseNo];
        }

        // case 1: don't rob curr house -> move to next house
        int dontRobCurrHouse = rob(houses, currHouseNo - 1, firstHouse, cache);

        // case 2: rob curr house -> move to next to next house
        int robCurrHouse = rob(houses, currHouseNo - 2, firstHouse, cache) + houses[currHouseNo];

        // we need to return max robbed amount
        cache[currHouseNo] = Math.max(dontRobCurrHouse, robCurrHouse);
        return cache[currHouseNo];
    }
}
