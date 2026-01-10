// https://leetcode.com/problems/valid-perfect-square/description/

class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;

        while(start <= end) {
            int mid = start + (end - start)/2;
            long midSquare = square(mid);

            if (midSquare == num) {
                return true;
            } else if (midSquare > num) {
                // need smaller mid -> move LEFT
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    private long square(int mid) {
        return (long) mid * mid;
    }
}

/* Learning:
1. In BSoA its really important to understand that we need to move left or right
   And movement of left/right depent on value of start/end - Need to understand this carefully
2. In BSoA we can face overflow issue, hence better to have long for calculation   


TC: logn
SC: O(1)
*/
