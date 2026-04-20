// https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/

class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = Integer.MIN_VALUE;
        for (int candy: candies) {
            max = Math.max(candy, max);
        }

        int start = 1; // EDGE CASE: think well start will be 0 or 1, here we do division by mid in isPossible() hence its 1 
        int end = max;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (isPossible(candies, mid, k)) {
                // we are able to divide
                // we want to maximum number of candies each child can get
                // that mean maximize mid
                // move RIGHT
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] candies, int mid, long k) {
        long candyBatch = 0;
        for (int candy: candies) {
            candyBatch += candy/mid;
        }
        return candyBatch >= k;
    }
}

/* Learning
1. Undersatring that what will be value of start and end in BSoA
*/
