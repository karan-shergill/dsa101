// https://leetcode.com/problems/sqrtx/description/

class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int start = 1;
        int end = x;
        int possibleAns = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            long val = getSqrt(mid);

            if (val == x) {
                return mid;
            } else if (val > x) {
                // need a smaller val
                // need a smaller mid
                // for smaller mid move LEFT
                end = mid - 1;
            } else {
                possibleAns = mid;
                start = mid + 1;
            }
        }

        return possibleAns;
    }

    private long getSqrt(int mid) {
        return (long) mid * mid;
    }
}

/* Learning:
1. In BS / BSoA, keep in mind the edge case of value 0 and 1

TC: logn
SC: O(1)
*/
