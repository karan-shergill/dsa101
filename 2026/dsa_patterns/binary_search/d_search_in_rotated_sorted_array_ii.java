// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

// if nums[0] == nums[nums.length - 1] -> dosn't mean array has just single no all along
class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        while (start < nums.length - 1) {
            if (nums[start] == nums[start + 1]) {
                start++;
            } else {
                break;
            }
        }

        if (start == nums.length - 1) {
            // array is single element OR all elements in array were same
            if (nums[start] == target) {
                return true;
            }
            return false;
        }

        int end = nums.length - 1;
        while (end > 0) {
            if (nums[end] == nums[end - 1]) {
                end--;
            } else {
                break;
            }
        }

        //at this point both start & end won't have duplicates
        // EDGE CASE: start and end element's can be the same
        if (nums[start] == nums[end]) {
            if (nums[start] == target) {
                return true;
            } else {
                start++;
            }
        }

        // start and end element are diff now: this will help in checking the sorted side

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[start] == nums[mid]) {
                start = mid + 1;
                continue;
            }

            if (nums[end] == nums[mid]) {
                end = mid - 1;
                continue;
            }

            if (nums[start] < nums[mid]) {
                // 1st half is sorted
                if (nums[start] <= target && target < nums[mid]) {
                    // target can be in 1st half
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // 2nd half is sorted
                if (nums[mid] < target && target <= nums[end]) {
                    // target can be in 2nd half
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }
}
