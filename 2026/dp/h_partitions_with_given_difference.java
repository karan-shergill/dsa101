// https://www.geeksforgeeks.org/problems/partitions-with-given-difference/0

// RECURSIVE
class Solution {
    public int countPartitions(int[] arr, int diff) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        
        if ((sum + diff) % 2 != 0) {
            return 0;
        }
            
        int target = (sum + diff)/2;
        return countPartitions(arr, target, 0);
    }

    private int countPartitions(int[] arr, int target, int currIndex) {
        if (currIndex == arr.length) {
            return target == 0 ? 1 : 0;
        }

        int take = 0;
        if (target >= arr[currIndex]) {
            take = countPartitions(arr, target - arr[currIndex], currIndex + 1);
        }
        int dontTake = countPartitions(arr, target , currIndex + 1);

        return take + dontTake;
    }
}

/*
sum(S1) - sum(S2) = diff
sum(S1) + sum(S2) = totalSum

2 * sum(S1) = totalSum + diff
sum(S1) = (totalSum + diff) / 2
*/

// TOP-DOWN
class Solution {
    public int countPartitions(int[] arr, int diff) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        
        if ((sum + diff) % 2 != 0) {
            return 0;
        }
            
        int target = (sum + diff)/2;

        Integer[][] cache = new Integer[arr.length][target + 1];
        return countPartitions(arr, target, 0, cache);
    }

    private int countPartitions(int[] arr, int target, int currIndex, Integer[][] cache) {
        if (currIndex == arr.length) {
            return target == 0 ? 1 : 0;
        }

        if (cache[currIndex][target] != null) {
            return cache[currIndex][target];
        }

        int take = 0;
        if (target >= arr[currIndex]) {
            take = countPartitions(arr, target - arr[currIndex], currIndex + 1, cache);
        }
        int dontTake = countPartitions(arr, target , currIndex + 1, cache);

        cache[currIndex][target] = take + dontTake;
        return cache[currIndex][target];
    }
}

/*
sum(S1) - sum(S2) = diff
sum(S1) + sum(S2) = totalSum

2 * sum(S1) = totalSum + diff
sum(S1) = (totalSum + diff) / 2
*/
