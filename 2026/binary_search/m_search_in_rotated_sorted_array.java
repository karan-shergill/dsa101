// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (target == nums[mid]) {
                return mid;
            }

            // Check which side is sorted
            if (nums[start] <= nums[mid]) {
                // left side is sorted
                if (nums[start] <= target && target < nums[mid]) {
                    // check is target can be in left side
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // right side is sorted
                if (nums[mid] < target && target <= nums[end]) {
                    // check is target can be in right side
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}

/* Learning:
In BS always think with intution and see which direction to move
Key point is to to look for edge case like 1,2 or 3 elements n array, also try to dry run on edge case
*/
