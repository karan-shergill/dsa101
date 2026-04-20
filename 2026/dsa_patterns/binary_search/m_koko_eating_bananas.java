// https://leetcode.com/problems/koko-eating-bananas/description/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 0;
        int end = getMax(piles);

        int speed = -1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if (canEatAllBananaInMidHours(piles, mid, h)) {
                // coco can try to eat more slowly
                // for slow speed, mid need to be lower
                // for lower mid value we will move LEFT
                end = mid - 1;
                speed = mid;
            } else {
                start = mid + 1;
            }
        }
        return speed;
    }

    private boolean canEatAllBananaInMidHours(int[] piles, int mid, int h) {
        int hours = 0;

        for (int banana: piles) {
            hours += Math.ceil((double) banana / mid); // EDGE CASE: convert int to float
        }

        return hours <= h; // EDGE CASE: within h hours includes h as well, hence should be <= and not <
    }

    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}

/* Learning:
In BSoA things that need to take care of:
1. EDGE CASE: within h hours includes h as well, hence should be <= and not <
2. EDGE CASE: convert int to float - this is very IMP whenever we use Math.ceil or Math.floor
3. In BSoA understand well where to move LEFT or RIGHT
*/
