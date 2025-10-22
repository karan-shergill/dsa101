// https://leetcode.com/problems/search-insert-position/description/

// submissions 1
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (target < nums[left]) return 0;
        if (target > nums[right]) return right + 1;

        int possibleIndex = 0;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                possibleIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return possibleIndex;
    }
}

// submissions 2
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int possibleIndex = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
                possibleIndex = mid;
            } else {
                start = mid + 1;
            }
        }

        return possibleIndex == -1 ? nums.length : possibleIndex;
    }
}

