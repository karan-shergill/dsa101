// https://leetcode.com/problems/partition-equal-subset-sum/description/

// RECURSIVE
class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int val : nums) {
            sum += val;
        }

        if (sum % 2 != 0) {
            return false;
        }

        return isSubsetSum(nums, 0, sum / 2);
    }

    Boolean isSubsetSum(int arr[], int currIndex, int sum) {
        if (sum == 0) {
            return true;
        }

        if (sum < 0 || currIndex >= arr.length) {
            return false;
        }

        Boolean take = isSubsetSum(arr, currIndex + 1, sum - arr[currIndex]);
        Boolean donTake = isSubsetSum(arr, currIndex + 1, sum);

        return take || donTake;
    }
}

// TOP-DOWN
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int val : nums) {
            sum += val;
        }

        if (sum % 2 != 0) {
            return false;
        }

        Boolean[][] cache = new Boolean[nums.length][(sum/2) + 1];
        return isSubsetSum(nums, 0, sum/2, cache);
    }

    static Boolean isSubsetSum(int arr[], int currIndex, int sum, Boolean[][] cache) {
        if (sum == 0) {
            return true;
        }

        if (sum < 0 || currIndex >= arr.length) {
            return false;
        }

        if (cache[currIndex][sum] != null) {
            return cache[currIndex][sum];
        }

        Boolean take = isSubsetSum(arr, currIndex + 1, sum - arr[currIndex], cache);
        Boolean donTake = isSubsetSum(arr, currIndex + 1, sum, cache);

        cache[currIndex][sum] = take || donTake;
        return cache[currIndex][sum];
    }
}
