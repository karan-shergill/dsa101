// https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1

// RECURSIVE
class Solution {

    public int minDifference(int arr[]) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }

        return minDifference(arr, sum, 0, 0);
    }

    private int minDifference(int[] arr, int totalSum, int currIndex, int sumTillNow) {

        if (currIndex == arr.length) {
            return Math.abs(totalSum - (2 * sumTillNow));
        }


        int take = minDifference(arr, totalSum, currIndex + 1, sumTillNow + arr[currIndex]);
        int dontTake = minDifference(arr, totalSum, currIndex + 1, sumTillNow);

        return Math.min(take, dontTake);
    }
}

/*
S1 = subset 1
S2 = subset 2
Goal: Minimize |S2 - S1|

S = Sum Of Arrays
S2 = S - S1

Goal: Minimize |S2 - S1|
      Minimize |S - S1 - S1|
      Minimize |S - 2*S1|
*/

// TOP-DOWN
class Solution {

    public int minDifference(int arr[]) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }

        Integer[][] cache = new Integer[arr.length][sum + 1];
        return minDifference(arr, sum, 0, 0, cache);
    }

    private int minDifference(int[] arr, int totalSum, int currIndex, int sumTillNow, Integer[][] cache) {

        if (currIndex == arr.length) {
            return Math.abs(totalSum - (2 * sumTillNow));
        }

        if(cache[currIndex][sumTillNow] != null) {
            return cache[currIndex][sumTillNow];
        }

        int take = minDifference(arr, totalSum, currIndex + 1, sumTillNow + arr[currIndex], cache);
        int dontTake = minDifference(arr, totalSum, currIndex + 1, sumTillNow, cache);

        cache[currIndex][sumTillNow] = Math.min(take, dontTake);
        return cache[currIndex][sumTillNow];
    }
}

/*
S1 = subset 1
S2 = subset 2
Goal: Minimize |S2 - S1|

S = Sum Of Arrays
S2 = S - S1

Goal: Minimize |S2 - S1|
      Minimize |S - S1 - S1|
      Minimize |S - 2*S1|
*/
