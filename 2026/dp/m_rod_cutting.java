// https://www.geeksforgeeks.org/problems/rod-cutting0840/1

// RECURSIVE
class Solution {
    public int cutRod(int[] price) {
        int rodLen = price.length;
        return cutRod(rodLen, price, 0);
    }

    private int cutRod(int rodLen, int[] price, int currIndex) {
        if (rodLen == 0) {
            return 0;
        }

        if (currIndex == price.length) {
            return Integer.MIN_VALUE;
        }

        int cut = 0;
        if (rodLen >= (currIndex + 1)) {
            cut = cutRod(rodLen - (currIndex + 1), price, currIndex);
            if (cut != Integer.MIN_VALUE) {
                cut += price[currIndex];
            }
        }

        int dontCut = cutRod(rodLen, price, currIndex + 1);

        return Math.max(cut, dontCut);
    }
}

// TOP DOWN
class Solution {
    public int cutRod(int[] price) {
        int rodLen = price.length;
        Integer[][] cache = new Integer[rodLen+1][price.length];
        return cutRod(rodLen, price, 0, cache);
    }

    private int cutRod(int rodLen, int[] price, int currIndex, Integer[][] cache) {
        if (rodLen == 0) {
            return 0;
        }

        if (currIndex == price.length) {
            return Integer.MIN_VALUE;
        }

        if (cache[rodLen][currIndex] != null) {
            return cache[rodLen][currIndex];
        }

        int cut = 0;
        if (rodLen >= (currIndex + 1)) {
            cut = cutRod(rodLen - (currIndex + 1), price, currIndex, cache);
            if (cut != Integer.MIN_VALUE) {
                cut += price[currIndex];
            }
        }

        int dontCut = cutRod(rodLen, price, currIndex + 1, cache);

        cache[rodLen][currIndex] = Math.max(cut, dontCut);
        return cache[rodLen][currIndex];
    }
}
