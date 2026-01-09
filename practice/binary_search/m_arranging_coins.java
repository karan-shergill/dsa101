// https://leetcode.com/problems/arranging-coins/description/

class Solution {
    public int arrangeCoins(int n) {
        int start = 0;
        int end = n;
        int possibleAns = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (isPossible(mid, n)) {
                possibleAns = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return possibleAns;
    }

    private boolean isPossible(int mid, int n) {
        long cal = (long)mid * (mid + 1) / 2;
        return cal<=n;
    }
}

/* Learning:
1. In BSoA its really important to understand that we need to move left or right
   And movement of left/right depent on value of start/end - Need to understand this carefully
2. In BSoA we can face overflow issue, hence better to have long for calculation   


TC: nlogn
SC: O(1)
*/
