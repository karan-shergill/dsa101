// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            min = Math.min(min, nums[mid]);

            if (nums[start] <= nums[mid]) {
                // 1st half is sorted
                if (nums[start] > nums[end]) {
                    // nums[start] <= nums[mid] && nums[start] > nums[end]
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                // nums[mid] <= nums[end]
                // 2nd half is sorted
                if (nums[start] > nums[end]) {
                    // nums[mid] <= nums[end] && nums[start] > nums[end]
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return min;
    }
}

/* Learning:
In BS always think with intution and see which direction to move
Key point is to to look for edge case like 1,2 or 3 elements n array, also try to dry run on edge case
*/
