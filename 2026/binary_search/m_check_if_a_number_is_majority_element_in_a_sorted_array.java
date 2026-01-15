// https://neetcode.io/problems/check-if-a-number-is-majority-element-in-a-sorted-array/question

// Brute Force - TC: O(n)
class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (nums[start] != target) {
            start++;
            if (start >= end) return false;
        }
        while (nums[end] != target) {
            end--;
            if (end == start) return false;
        }

        return   end - start + 1 > nums.length/2;
    }
}


// Optinal: BS - TC: logn

class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int firstIndex = getFirstOccurance(nums, target);
        int lastIndex = getLastOccurance(nums, target);

        System.out.println(firstIndex + "_" + lastIndex);

        if (firstIndex == -1) {
            return false;
        }

        return lastIndex - firstIndex + 1 > nums.length/2;
    }

    private int getFirstOccurance(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] >= target) {
                index = mid;
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

/* Leaning
1. Sometime need to think out of the box, as this was child problem of first/last occurance
2. These kind of problem have alot of edge cases, need to think and test all
*/
