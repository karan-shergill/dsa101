// https://leetcode.com/problems/single-element-in-a-sorted-array/description/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;

        if (len == 1)
            return nums[0];

        if (nums[0] != nums[1]) 
            return nums[0];
        if (nums[len-1] != nums[len-2]) 
            return nums[len-1];

        int start = 0;
        int end = len-1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if (nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }

            if (mid % 2 == 0) {
                if (nums[mid] != nums[mid+1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] != nums[mid-1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}

/* Leaning
1. Know and think of edge case in BS like when array have size 1 or 2 or 3
2. In BS we need to think we need to move LEFT or RIGHT to find the element, mostly we decide on the basis on value of array(mid) but sometimes index also helps like in this problem.
*/
