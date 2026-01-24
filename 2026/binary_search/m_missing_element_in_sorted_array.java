// https://neetcode.io/problems/missing-element-in-sorted-array/question

// The parent Q of this Q is : https://leetcode.com/problems/kth-missing-positive-number/

class Solution {
    public int missingElement(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            int expectedVal = mid + arr[0];
            int actualVal = arr[mid];

            if (actualVal - expectedVal < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        int expectedVal = arr[0] + end;
        int actualVal = arr[end];

        return actualVal + k - (actualVal-expectedVal);
    }
}
