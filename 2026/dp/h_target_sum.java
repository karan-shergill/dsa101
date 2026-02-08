// https://leetcode.com/problems/target-sum/description/
// PARENT Q: https://www.geeksforgeeks.org/problems/partitions-with-given-difference/0

// RECURSIVE
class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) sum += n;

        // Impossible case
        if ((sum + target) % 2 != 0 || Math.abs(target) > sum) {
            return 0;
        }

        int required = (sum + target) / 2;
        return countSubsets(nums, 0, required);
    }

    private int countSubsets(int[] nums, int index, int target) {
        // Base case: all elements processed
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }

        int take = 0;
        if (nums[index] <= target) {
            take = countSubsets(nums, index + 1, target - nums[index]);
        }
        int dontTake = countSubsets(nums, index + 1, target);

        return take + dontTake;
    }
}

// TOP-DOWN
class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) sum += n;

        // Impossible case
        if ((sum + target) % 2 != 0 || Math.abs(target) > sum) {
            return 0;
        }

        int required = (sum + target) / 2;
        Integer[][] cache = new Integer[nums.length][required + 1];
        return countSubsets(nums, 0, required, cache);
    }

    private int countSubsets(int[] nums, int index, int target, Integer[][] cache) {
        // Base case: all elements processed
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }

        if (cache[index][target] != null) {
            return cache[index][target];
        }

        int take = 0;
        if (nums[index] <= target) {
            take = countSubsets(nums, index + 1, target - nums[index], cache);
        }
        int dontTake = countSubsets(nums, index + 1, target, cache);

        cache[index][target] = take + dontTake;
        return cache[index][target];
    }
}

/*
sum(S1) - sum(S2) = diff
sum(S1) + sum(S2) = totalSum

2 * sum(S1) = totalSum + diff
sum(S1) = (totalSum + diff) / 2
*/
