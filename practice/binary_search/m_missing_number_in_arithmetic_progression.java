// https://neetcode.io/problems/missing-number-in-arithmetic-progression/question

// Brute Force

class Solution {
    public int missingNumber(int[] arr) {
        int first = arr[1] - arr[0];
        int second = arr[arr.length-1] - arr[arr.length-2];

        if (first != second) {
            if (first < 0) {
                return first > second ? arr[arr.length-2] + first : arr[0] + second;
            } else {
                return first > second ? arr[0] + second : arr[arr.length-2] + first;
            }
        } 

        boolean neg = false;
        if (first < 0) {
            neg = true;
        }

        for (int i=0; i<arr.length-1; i++) {
            int currVal = arr[i+1] - arr[i];

            if (currVal != first) {
                return arr[i] + first;
            }
        }

        return arr[0];
    }
}

// TC: O(n)
// SC: O(1)

// Binary Search

class Solution {
    public int missingNumber(int[] arr) {
        int first = arr[1] - arr[0];
        int second = arr[arr.length-1] - arr[arr.length-2];

        if (first != second) {
            if (first < 0) {
                return first > second ? arr[arr.length-2] + first : arr[0] + second;
            } else {
                return first > second ? arr[0] + second : arr[arr.length-2] + first;
            }
        } 

        int diff = first;
        
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (arr[mid] == arr[0] + (mid * diff)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return arr[0] + (diff * start);
    }
}

/* Learning
1. Need to take care of +ve and -ve diffrence
2. For BS need to think how we move LEFT or RIGHT

TC: logn
SC: o(1)
*/
