// https://leetcode.com/problems/climbing-stairs/description/

// RECURSIVE
class Solution {

    public int climbStairs(int n) {
        // EDGE CASE: n <= 1
        if (n <= 1) {
            return n;
        }

        return climbStairsUtil(n);
    }

    private int climbStairsUtil(int n) {
        // R base case
        if (n < 0) {
            return 0;
        }
        // R base case
        if (n == 0) {
            return 1;
        }

        return climbStairsUtil(n - 1) + climbStairsUtil(n - 2);
    }
}

// MEMOIZATION 
class Solution {

    public int climbStairs(int n) {
        // EDGE CASE: n <= 1
        if (n <= 1) {
            return n;
        }

        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);

        return climbStairsUtil(n, cache);
    }

    private int climbStairsUtil(int n, int[] cache) {
        // R base case
        if (n < 0) {
            return 0;
        }
        // R base case
        if (n == 0) {
            return 1;
        }

        if (cache[n] != -1) {
            return cache[n];
        }

        cache[n] = climbStairsUtil(n - 1, cache) + climbStairsUtil(n - 2, cache);
        return cache[n];
    }
}

