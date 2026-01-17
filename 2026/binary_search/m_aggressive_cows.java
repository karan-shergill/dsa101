// https://www.geeksforgeeks.org/problems/aggressive-cows/1

class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // given an array with unique elements of stalls[], which denote the positions of stalls
        // you are also given an integer k which denotes the number of aggressive cows
        // assign stalls to k cows such that the minimum distance between any two of them is the maximum possible

        Arrays.sort(stalls);

        int start = 0;
        int end = stalls[stalls.length - 1];
        int pAns = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (isPossible(stalls, k, mid)) {
                // so it was possible to place at least k cows, at least mid distance apart from each other
                pAns = mid;
                // we need to maximize the min distance
                // we need to maximize the mid 
                // to increase mid move RIGHT
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return pAns;
    }

    private boolean isPossible(int[] stalls, int k, int midDistance) {
        // We will try to find no of cows that can be places away from each other with mininum distance among them as midDistance
        // Distance more than midDistance is possible, but cows should have at least midDistance among them

        // count no of cows possible to place
        // EDGE CASE: we have countCow as we have already placed the 1st cow at index 0
        int countCow = 1;

        // last postion on cow
        int lastPosition = 0;

        for (int i=1; i<stalls.length; i++) {
            // check distance of curr cow with last cow if placed on curr index
            if (stalls[i] - stalls[lastPosition] >= midDistance) {
                // place the curr cow on curr index
                countCow++;
                lastPosition = i;
            }
        }

        // check if were able to place at least k cows in total
        return countCow >= k;
    }
}
