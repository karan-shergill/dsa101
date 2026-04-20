// https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

// RECURSIVE
class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        return isSubsetSum(arr, 0, sum);
    }

    static Boolean isSubsetSum(int arr[], int currIndex, int sum) {
        if (sum == 0) {
            return true;
        }

        if (sum < 0 || currIndex >= arr.length) {
            return false;
        }

        Boolean take = isSubsetSum(arr, currIndex + 1, sum - arr[currIndex]);
        Boolean donTake = isSubsetSum(arr, currIndex + 1, sum);

        return take || donTake;
    }
}

// TOP-DOWN
class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        Boolean[][] cache = new Boolean[arr.length][sum + 1];
        return isSubsetSum(arr, 0, sum, cache);
    }

    static Boolean isSubsetSum(int arr[], int currIndex, int sum, Boolean[][] cache) {
        if (sum == 0) {
            return true;
        }

        if (sum < 0 || currIndex >= arr.length) {
            return false;
        }

        if (cache[currIndex][sum] != null) {
            return cache[currIndex][sum];
        }

        Boolean take = isSubsetSum(arr, currIndex + 1, sum - arr[currIndex], cache);
        Boolean donTake = isSubsetSum(arr, currIndex + 1, sum, cache);

        cache[currIndex][sum] = take || donTake;
        return cache[currIndex][sum];
    }
}
