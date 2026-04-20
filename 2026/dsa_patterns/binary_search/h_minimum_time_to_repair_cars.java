// https://leetcode.com/problems/minimum-time-to-repair-cars/description/

// Intutive solution
class Solution {
    public long repairCars(int[] ranks, int cars) {
        // Given to us is ranks[] and cars
        // ranks[]: rank of mechanics, minimum the rank of mechanics, the faster he is
        // Speed of mechanics: A mechanic with a rank r can repair n cars in r * n^2 minutes.
        // cars: no of cars waiting in guarage
        // We need to return the minimum time taken to repair all the cars. All the mechanics can repair the cars simultaneously.

        // time for completion can be between 1 to MAX_VALUE

        long start = 1;
        long end = Long.MAX_VALUE;
        long ans = 0;

        while (start <= end) {
            long mid = start + (end - start)/2;

            if (isPossible(ranks, cars, mid)) {
                // so cars can be fixed in mid time
                // we need to minimise the time taken
                // that mean we need to minimize the mid -> move end to LEFT

                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] ranks, int cars, long timeToRepair) {
        // can all the cars be repaired under timeToRepair?
        // Each mechanic should work only on that many cars that he can fix under timeToRepair

        long totalNoOfCarRepaired = 0;

        for (int i=0; i<ranks.length; i++) {
            // let's see how many cars can be fixed by mechanic ranks[i] under timeToRepair

            long start = 1;
            long end = cars - totalNoOfCarRepaired;
            long potencialNoOfCars = 0;

            while (start <= end) {
                long mid = start + (end - start)/2;

                if (getRepairTime(ranks[i], mid) <= timeToRepair) {
                    // mechanic i can repair mid no of cars under timeToRepair
                    // let's see if he can fix more cars
                    // more car -> more mid -> move start to RIGHT
                    potencialNoOfCars = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            totalNoOfCarRepaired += potencialNoOfCars;
        }

        return totalNoOfCarRepaired >= cars;
    }

    private long getRepairTime(int rank, long noOfCars) {
        return (long) rank * noOfCars * noOfCars;
    }
}
