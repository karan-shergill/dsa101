// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        // given an integer array nums where the ith bag contains nums[i] balls
        // given maxOperation
        // we can perform the operation at most maxOperations times (<= less than equal to maxOperations)
        // maxOperation: Take any bag of balls and divide it into two new bags with a positive number of balls.

        // Your penalty is the maximum number of balls in a bag. 
        // You want to minimize your penalty after the operations.

        // Return the minimum possible penalty after performing the operations.

        Arrays.sort(nums);

        int start = 0;
        int end = nums[nums.length - 1];
        int pAns = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (canWeMakeBagsSmallerOrEqualToMidInMaxOp(nums, maxOperations, mid)) {
                pAns = mid;
                // we need to find min possible mid, move LEFT to minimize mid
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return pAns;
    }

    private boolean canWeMakeBagsSmallerOrEqualToMidInMaxOp(int[] bags, int maxOperations, int mid) {
        // count NUMBER of division/operation of bag needed so that every bag has <= mid balls
        int operationTook = 0;

        for (int currBag : bags) {
            if (currBag <= mid) {
                continue;
            }
            // most IMP part: no of opartion is this formula as: 
            // 8/2 - 1: 3 operation, e.i. 3 operation needed to divide 8 into all 2s
            // 17/2 -1: 7 operation, i,e  7 operation needed to divide 17 into all 2s
            operationTook += Math.ceil((double)currBag/mid) - 1;
        }
        return operationTook<=maxOperations;
    }
}
