// https://leetcode.com/problems/minimum-speed-to-arrive-on-time/description/

class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int start = 1;
        int end = 10000000;
        int pAns = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (isPossible(dist, hour, mid)) {
                pAns = mid;
                //look for smaller mid
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return pAns;
    }

    private boolean isPossible(int[] dist, double hour, int mid) {
        double timeTaken = 0.0;

        for (int i=0; i<dist.length-1; i++) {
            // We need to wound-off to ceil as asked in the Q
            timeTaken += Math.ceil((double)dist[i]/mid);
        }
        // This is main EDGE CASE of the problem: the last train shouldn't need wound-off
        timeTaken += (double)dist[dist.length-1]/mid;

        return timeTaken <= hour;
    }
}
