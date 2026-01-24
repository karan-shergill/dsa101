// https://leetcode.com/problems/kth-missing-positive-number/description/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            int expectedVal = mid + 1;
            int actualVal = arr[mid];

            if (actualVal - expectedVal < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // EDGE CASE: why we need to do (+1) here?
        return end + k + 1;
    }
}
