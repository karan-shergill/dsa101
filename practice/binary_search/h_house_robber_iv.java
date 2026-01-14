// https://leetcode.com/problems/house-robber-iv/description/

class Solution {
    public int minCapability(int[] houses, int k) {
        // k: minimum no of houses the robber needs to rob
        // houses[]: houses with houses[i] denoting the currency value in that house
        // robber can't rob adjacent homes
        // capability of the robber: maximum amount of money he steals from one house of all the houses he robbed, that means he he robs 3 houses, the max(amount from all 3 houses) will be robber's capability
        // robber need to reduce his capability while robbing minimum of k non-adjecent houses

        int max = Integer.MIN_VALUE;
        for (int house : houses) {
            max = Math.max(max, house);
        }

        int start = 0;
        int end = max;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (isPossible(houses, k, mid)) {
                // so currently it's possible to rob k non adjecent houses with max capability as mid
                // as we need to reduce the capability, we need to reduce the mid
                // to reduce mid move LEFT
                end = mid - 1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] houses, int k, int maxCapability) {
        //maxCapability is maximum value at house[i], so robber can rob a house that had value less than maxCapability
        int houseIndex = 0;
        int houseCount = 0;

        while (houseIndex < houses.length) {
            if (houses[houseIndex] <= maxCapability) {
                houseIndex += 2;
                houseCount++;
            } else {
                houseIndex += 1;
            }
        }

        return houseCount >= k;
    }
}

/* Leaning:
This Q was complex because of the way the Q forms the problem statemenet, for BSoA Qs its really really important to break down the Q and requiremenets well enough.
This Q would also make us think it's DP problem but that's really not the case.
*/
