// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = getFirstOccurance(nums, target);
        int last = getLastOccurance(nums, target);

        return new int[]{first, last};
    }

    private int getFirstOccurance(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                index = mid;
                end = mid - 1;
            }else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return index;
    }

    private int getLastOccurance(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                index = mid;
                start = mid + 1;
            }else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return index;
    }
}

/* Leaning
1. This is base problem, there can Q, where we need to understand that its actully a varient of this Q, like https://neetcode.io/problems/check-if-a-number-is-majority-element-in-a-sorted-array/question
2. Testcases can be tricky, better to dryrun for diffrent testcases.
*/
