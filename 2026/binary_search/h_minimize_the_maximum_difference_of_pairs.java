// https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/

class Solution {
    public int minimizeMax(int[] nums, int p) {
        // nums[] is an array with int value
        // p is number of pairs that we need to form
        // a pair can have a absolute diffrence adiff
        // for `p` pairs, we will have `p` number of `adiff`
        // we need to return max of all (adiff)
        // our aim is to minimize (max of all (adiff))

        // as we know this problen has BSoA
        // we need to check if its possible to create p pairs with mid as absolute diffrence

        Arrays.sort(nums);

        int start = 0;
        int end = nums[nums.length-1];

        int pAns = 0;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (isPossibleToCreatePPairs(nums, p, mid)) {
                // its possible to create p pairs with mid as appsolute diff
                pAns = mid;
                // can we find a better ans? we need to minimize (max of all (adiff))
                // we need to minimize the mid
                // move LEFT for lower mid
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return pAns;
    }

    private boolean isPossibleToCreatePPairs(int[] nums, int p, int mid) {
        int pairsCount = 0;
        int index = 0;

        while (index < nums.length-1) {
            if (nums[index+1] - nums[index] <= mid) {
                // pair found
                pairsCount++;
                index += 2;
            } else {
                index += 1;
            }
        }

        return pairsCount >= p;
    }
}

/* Learning
Like 2560. House Robber IV, we need to understand this Q very well
the actul hard part is not BSoA, but the greedy count of pairs in both the problems
*/
