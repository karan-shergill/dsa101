// https://neetcode.io/problems/divide-chocolate/question

// this problemis opposite of https://leetcode.com/problems/split-array-largest-sum/

class Solution {

    public int maximizeSweetness(int[] sweetness, int k) {
        /*
            You have one chocolate bar split into chunks.
            You want to make k cuts → k + 1 pieces.
            You will eat the piece with the MINIMUM total sweetness.
            Goal: MAXIMIZE that minimum sweetness.
        */

        // Minimum sweetness possible:
        // At least the minimum value in the array
        int minSweetness = Integer.MAX_VALUE;

        // Maximum sweetness possible:
        // Sum of all chunks (if no cuts were made)
        int totalSweetness = 0;

        for (int val : sweetness) {
            totalSweetness += val;
            minSweetness = Math.min(minSweetness, val);
        }

        int start = minSweetness;
        int end = totalSweetness;
        int ans = 0;


        while (start <= end) {

            // Candidate minimum sweetness
            int mid = start + (end - start) / 2;

            /*
                Check:
                Can we make at least (k + 1) pieces
                such that each piece has sweetness >= mid ?
            */
            if (isPossibleToCutInPieces(sweetness, k, mid)) {
                // mid is feasible → try to maximize it -> move RIGHT
                ans = mid;
                start = mid + 1;
            } else {
                // mid is too large → reduce it -> move LEFT
                end = mid - 1;
            }
        }

        return ans;
    }

    private boolean isPossibleToCutInPieces(int[] sweetness, int k, int minSweetness) {
        /*
            Greedily form pieces where each piece has
            total sweetness >= minSweetness.
        */

        int pieceCount = 0;
        int currentSweetness = 0;

        for (int sweet : sweetness) {
            currentSweetness += sweet;

            // Once we reach the required minimum,
            // we form a piece and reset
            if (currentSweetness >= minSweetness) {
                pieceCount++;
                currentSweetness = 0;
            }
        }

        /*
            We need at least (k + 1) pieces.
            More pieces are OK — we can always merge.
        */
        return pieceCount >= k + 1;
    }
}
