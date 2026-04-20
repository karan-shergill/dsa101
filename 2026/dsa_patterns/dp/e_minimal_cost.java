// https://www.geeksforgeeks.org/problems/minimal-cost/1

// RECURSIVE
class Solution {
    public int minimizeCost(int k, int arr[]) {
        return minimizeCost(k, arr, arr.length - 1);
    }


    private int minimizeCost(int k, int[] arr, int currIndex) {
        if (currIndex == 0) {
            return 0;
        }

        int minCostFromCurrentIndex = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int jumpIndex = currIndex - i;

            if (jumpIndex < 0) {
                break;
            }

            int currJumpCost = minimizeCost(k, arr, jumpIndex) + Math.abs(arr[currIndex] - arr[jumpIndex]);
            minCostFromCurrentIndex = Math.min(currJumpCost, minCostFromCurrentIndex);
        }
        return minCostFromCurrentIndex;
    }
}

// TOP DOWN
class Solution {
    public int minimizeCost(int k, int arr[]) {
        int[] cache = new int[arr.length + 1];
        Arrays.fill(cache, -1);
        return minimizeCost(k, arr, arr.length - 1, cache);
    }


    private int minimizeCost(int k, int[] arr, int currIndex, int[] cache) {
        if (currIndex == 0) {
            return 0;
        }

        if (cache[currIndex] != -1) {
            return cache[currIndex];
        }

        int minCostFromCurrentIndex = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int jumpIndex = currIndex - i;

            if (jumpIndex < 0) {
                break;
            }

            int currJumpCost = minimizeCost(k, arr, jumpIndex, cache) + Math.abs(arr[currIndex] - arr[jumpIndex]);
            minCostFromCurrentIndex = Math.min(currJumpCost, minCostFromCurrentIndex);
        }
        cache[currIndex] = minCostFromCurrentIndex;
        return cache[currIndex];
    }
}
