// https://leetcode.com/problems/minimum-time-to-complete-trips/description/

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        // You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip
        // Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the current trip.
        // Each bus operates independently; that is, the trips of one bus do not influence the trips of any other bus.
        // You are also given an integer totalTrips, which denotes the number of trips all buses should make in total.
        // Return the minimum time required for all buses to complete at least totalTrips trips.

        Arrays.sort(time);

        long start = 1;
        long end = 100000000000000l;

        long pAns = -1;

        while (start <= end) {
            long mid = start + (end - start)/2;

            if (canTripsBeCompletedInTimeMid(time, totalTrips, mid)) {
                pAns = mid;
                // can we have a better min mid : min time
                // move LEFT to minimize min
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return pAns;
    }

    private boolean canTripsBeCompletedInTimeMid(int[] time, int totalTrips, long mid) {
        long tripCount = 0;

        for (int currBus: time) {
            tripCount += mid/currBus;
        }
        return totalTrips <= tripCount;
    }
}
