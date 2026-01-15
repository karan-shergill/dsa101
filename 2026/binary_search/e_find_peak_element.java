// https://leetcode.com/problems/find-peak-element/description/

class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return 0;

        if (nums[0] > nums[1])
            return 0;
        if (nums[len-1] > nums[len-2])
            return len-1;

        int start=1;
        int end=len-2;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if (nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
                return mid;
            }

            if (nums[mid] < nums[mid-1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}

/* Leaning
1. Always good to see constrains, in this Q if duplicate is allowed, solution would become more complex
*/
