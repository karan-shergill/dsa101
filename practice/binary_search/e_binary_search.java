// https://leetcode.com/problems/binary-search/

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}

/* Leanings:
1. end can't be nums.length, it needs to be nums.length-1
2. BS while loop needs to have while (start <= end) and not while (start < end)
3. To prohibit overflow mid needs to be start + (end - start)/2

TC: logn
SC: O(1)
*/
