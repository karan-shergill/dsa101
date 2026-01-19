// https://leetcode.com/problems/split-array-largest-sum/description/

class Solution {
    public int splitArray(int[] nums, int k) {
        // Given an integer array nums and an integer k
        // split nums into k non-empty subarrays such that the largest sum of any subarray is minimized
        // Return the minimized largest sum of the split

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int currVal : nums) {
            sum += currVal;
            max = Math.max(max, currVal);
        }

        int start = max;
        int end = sum;
        int pAns = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (isPossibleToSplitArrayWithMaxSumMid(nums, k, mid)) {
                // mid is a possible sum
                pAns = mid;
                end = mid - 1;
            } else {
                // more than k splits happened -> to reduce split, inc mid -> move right
                start = mid + 1;
            }
        }
        return pAns;
    }

    private boolean isPossibleToSplitArrayWithMaxSumMid(int[] nums, int k, int mid) {
        // check in how many splits array nums would be divided if the max sum allows is mid

        int splitCount = 1;
        int currSum = 0;

        for (int val : nums) {
            currSum += val;

            if (currSum > mid) {
                // this split not possible - add val in next split
                splitCount++;

                // add val for next split
                currSum = val;
            }
        }

        // check if we were able to split array with section sum less than mid and section count less than k
        return splitCount <= k;
    }
}
