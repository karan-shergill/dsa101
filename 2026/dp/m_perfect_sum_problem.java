// https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1

// RECURSIVE
class Solution {
    public int perfectSum(int[] nums, int target) {
        return perfectSum(nums, target, 0);
    }

    private int perfectSum(int[] nums, int target, int currIndex) {
        // Base cases
        if (currIndex == nums.length) {
            // Reached end of array - check if target is 0
            // we check currIndex with nums.length and not nums.length-1 as for case 0 there can be emply array as well
            return (target == 0) ? 1 : 0;
        }

        int take = perfectSum(nums, target - nums[currIndex], currIndex + 1);
        int dontTake = perfectSum(nums, target, currIndex + 1);

        return take + dontTake;
    }
}

// TOP-DOWN
class Solution {
    public int perfectSum(int[] nums, int target) {
        int[][] cache = new int[nums.length][target + 1];
        for (int i=0; i<cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return perfectSum(nums, target, 0, cache);
    }

    private int perfectSum(int[] nums, int target, int currIndex, int[][] cache) {
        // Base cases
        if (currIndex == nums.length) {
            return (target == 0) ? 1 : 0;
        }
        

        if (cache[currIndex][target] != -1) {
            return cache[currIndex][target];
        }

        int take = 0;
        if (target >= nums[currIndex]) {
            take = perfectSum(nums, target - nums[currIndex], currIndex + 1, cache);
        }
        int dontTake = perfectSum(nums, target, currIndex + 1, cache);

        cache[currIndex][target] = take + dontTake;
        return cache[currIndex][target];
    }
}
