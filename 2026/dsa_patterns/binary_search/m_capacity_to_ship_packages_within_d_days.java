// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        /*
        int max = Integer.MIN_VALUE;
        for (int weight : weights) {
            max = Math.max(weight, max);
        }
        */

        int start = 0;
        int end = Integer.MAX_VALUE; // EDGE CASE: end won't be be MAX_of(weights)
        int ans = -1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if (isPossibleToTrasport(weights, mid, days)) {
                // ship with `mid` weight is possible to trasport `weights` under `days`
                // let's now try to find a ship with a lower weight ~ lower `mid`
                // for lower mid move LEFT
                end = mid - 1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossibleToTrasport(int[] weights, int mid, int days) {
        int currDays = 0;
        int currWeight = 0;

        for (int i=0; i<weights.length; ) {
            if (currWeight+weights[i] <= mid) {
                currWeight+=weights[i];
                i++;
            } else {
                currDays++;
                currWeight=0;

                if (currDays > days) { // EDGE CASE: a single weight in array that is more than capacity of ship
                    return false;
                }
            }
        }
        currDays++; // EDGE CASE: last day need to take in account
        return currDays <= days;
    }
}

/* Learning
1. In BSoA, its imp to understand what will be the value of _start and _end, don't copy blindly 0 and max of array value
2. When counting days make sure its take into account of last day, of day count start with 1 not 0
*/
