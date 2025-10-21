// https://leetcode.com/problems/contains-duplicate-ii/description/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1) return false;

        k = nums.length < k ? nums.length : k;

        // Fixed sliding window size: k
        HashSet<Integer> set = new HashSet<>(); // set of size k

        // Process 1st fixed window of size K
        for (int i=0; i<k; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        // Move the fixed sized window forward
        for (int i=k; i<nums.length; i++) {
            // Increase window size
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);

            // Decrease window size
            set.remove(nums[i-k]);
        }

        return false;
    }
    //TC: O(n)
    //SC: O(k)
}

/*
Learning:
1. Use constant sliding window technique.
*/
