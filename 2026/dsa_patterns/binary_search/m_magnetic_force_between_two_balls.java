// https://leetcode.com/problems/magnetic-force-between-two-balls/description/

class Solution {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int start = 0;
        int end = position[position.length - 1];
        int pAns = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isPossible(position, m, mid)) {
                // we were able to place m ball at mid distance apart from each other
                pAns = mid;
                // we want minimum magnetic force between any two balls is maximum.
                // we want minimum magnetic distance between any two balls is maximum.
                // we mid distance between any two balls is maximum.
                // we want to maximize mid distance
                // to maximize mid move RIGHT
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return pAns;
    }

    private boolean isPossible(int[] position, int m, int minDistance) {
        // here we will check it's possible to place m balls away from each other with minDistance between them

        // Lets place 1st ball at 0th index
        int lastBallPosition = 0;

        // 1st ball we have already places at 0th index
        int ballCount = 1;

        for (int i = 1; i < position.length; i++) {
            // check if diff between basket is at least minDistance
            if (Math.abs(position[i] - position[lastBallPosition]) >= minDistance) {
                // curr ball can be places at minDistance from last position ball
                ballCount++;
                // update lastBallPosition
                lastBallPosition = i;
            }
        }

        // check if we were place to place at least m balls
        return ballCount >= m;
    }
}
