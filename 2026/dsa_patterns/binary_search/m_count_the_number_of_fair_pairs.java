// https://leetcode.com/problems/count-the-number-of-fair-pairs/description/

class Solution {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        long countLower = getCountFairPairs(nums, lower - 1);
        long countUpper = getCountFairPairs(nums, upper);
        return countUpper - countLower;
    }

    // count pairs in array that can add up to target
    private long getCountFairPairs(int[] nums, int target) {
        long count = 0l;

        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int newTarget = target - nums[i];
            int lastIndex = getLastIndexAddUpToTarget(nums, start, newTarget);

            if (lastIndex == -1) {
                break;
            }

            count += lastIndex - i;
        }

        return count;
    }

    // Get last occurance index of target in array
    private int getLastIndexAddUpToTarget(int[] nums, int start, int target) {
        int end = nums.length - 1;
        int index = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] <= target) {
                index = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return index;
    }
}
/* Learning:
This problem teaches an important concept of counting pairs in an array
*/
