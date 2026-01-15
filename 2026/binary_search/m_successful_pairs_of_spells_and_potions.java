// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);

        for (int i=0; i<spells.length; i++) {
            ans[i] = getCount(potions, spells[i], success);
        }

        return ans;
    }

    private int getCount(int[] potions, int multiplier, long success) {
        int start = 0;
        int end = potions.length-1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if ((long)potions[mid] * multiplier < success) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (start >= potions.length) // EDGE CASE: No Successful Pair
            return 0;

        return potions.length - start;
    }
}

/* Learning:
It's hard to think how BS is used in this Q if it come up just like that
This tells us that sometimes, its okay to sort the array and apply BS, its possible some Q are not sorted and are still a BS Q, where expectation is from us to sort the array

TC: O(Nlog(N)+Mlog(K))
*/
