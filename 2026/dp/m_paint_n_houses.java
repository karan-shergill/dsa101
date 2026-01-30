// https://www.geeksforgeeks.org/problems/distinct-coloring--170645/1

// RECURSIVE
class Solution {
    public static long distinctColoring(int N, int[] r, int[] g, int[] b) {
        return distinctColoring(N - 1, r, g, b, -1);
    }

    private static long distinctColoring(int currHouse, int[] r, int[] g, int[] b, int lastColor) {
        // BASE CASE: no house remaining to paint
        if (currHouse < 0) {
            return 0;
        }

        long minCost = Integer.MAX_VALUE;
        for (int i=1; i<=3; i++) {
            if (i != lastColor) {
                long currCost = distinctColoring(currHouse - 1, r, g, b, i);
                switch (i) {
                    case 1: currCost += r[currHouse]; break;
                    case 2: currCost += g[currHouse]; break;
                    case 3: currCost += b[currHouse]; break;
                }
                minCost = Math.min(minCost, currCost);
            }
        }

        return minCost;
    }
}

// TOP DOWN
class Solution {
    public static long distinctColoring(int N, int[] r, int[] g, int[] b) {
        long[][] cache = new long[N + 1][4];
        for (int i=0; i<=N; i++) {
            Arrays.fill(cache[i], -1);
        }
        
        return distinctColoring(N - 1, r, g, b, 0, cache);
    }

    private static long distinctColoring(int currHouse, int[] r, int[] g, int[] b, int lastColor, long[][] cache) {
        // BASE CASE: no house remaining to paint
        if (currHouse < 0) {
            return 0;
        }

        if (cache[currHouse][lastColor] != -1) {
            return cache[currHouse][lastColor];
        }

        long minCost = Long.MAX_VALUE;
        for (int i=1; i<=3; i++) {
            if (i != lastColor) {
                long currCost = distinctColoring(currHouse - 1, r, g, b, i, cache);
                switch (i) {
                    case 1: currCost += r[currHouse]; break;
                    case 2: currCost += g[currHouse]; break;
                    case 3: currCost += b[currHouse]; break;
                }
                minCost = Math.min(minCost, currCost);
            }
        }

        cache[currHouse][lastColor] = minCost;
        return cache[currHouse][lastColor];
    }
}
