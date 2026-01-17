// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // You want to make m bouquets
        // To make a bouquet, you need to use k adjacent flowers from the garden.
        // bloomDay[] is the gardern with m flowers
        // the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
        // Return the minimum number of days you need to wait to be able to make m bouquets from the garden.

        int max = Integer.MIN_VALUE;
        for (int bloom : bloomDay) {
            max = Math.max(max, bloom);
        }

        int start = 0;
        int end = max;
        int pAns = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (isPossible(bloomDay, m, k, mid)) {
                // we were able to make m bouquets in mid days
                pAns = mid;
                // we need to minimize the no of days: minimize mid: move LEFT
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return pAns;
    }

    private boolean isPossible(int[] bloomDay, int mBouquets, int kAdjFlowers, int midDays) {
        // we will check here if its possible to make mBouquets with kAdjFlowers in minDays or not

        // no of bouquets we can make un midDays
        int bouquetsCount = 0;
        // no of flowers in adj
        int adjFlowerCount = 0;

        for (int bloom: bloomDay) {
            // check if flower is bloomed in this day
            if (bloom <= midDays) {
                // its bloomed
                adjFlowerCount++;
            } else {
                // adj flower need to be in continuation, continution break here, so we count again
                adjFlowerCount = 0;
            }

            // check if we have got enough adj flowers to make a bouquet
            if (adjFlowerCount == kAdjFlowers) {
                bouquetsCount++;

                // reset adjFlowerCount again
                adjFlowerCount = 0;
            }
        }

        return bouquetsCount>= mBouquets;
    }
}
