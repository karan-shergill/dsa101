// https://leetcode.com/problems/most-beautiful-item-for-each-query/

class Solution {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Sort by 1st element, if equal then by 2nd element
        Arrays.sort(
            items,
            (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0]; // sort by first element
                }
                return a[1] - b[1]; // sort by second element
            }
        );
        int[] prefixSum = new int[items.length];
        fillPrefixSum(items, prefixSum);

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = getUpperBound(items, queries[i]);
            if (index == -1) { // EDGE CASE
                ans[i] = 0;
            } else {
                ans[i] = prefixSum[index];
            }
        }
        return ans;
    }

    private void fillPrefixSum(int[][] items, int[] prefixSum) {
        int currMax = 0;
        for (int i = 0; i < items.length; i++) {
            currMax = Math.max(currMax, items[i][1]);
            prefixSum[i] = currMax;
        }
    }

    private int getUpperBound(int[][] items, int target) {
        int start = 0;
        int end = items.length - 1;
        int pAns = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (items[mid][0] <= target) {
                pAns = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return pAns;
    }
}

/* Learning:
1. Sorting on a 2d array
2. How prefixsum helps in these kind of problem to reduce TC
*/
