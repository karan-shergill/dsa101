// https://leetcode.com/problems/find-in-mountain-array/description/

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // 1. Find the PEAK element's index `peakIndex`
        // 2. Try finding `target` between 0 to `peakIndex`
        // 3. Try finding `target` between `peakIndex` to `mountainArr.length()`

        // 1. Find the PEAK element's index `peakIndex`
        int peakIndex = getPeakIndex(mountainArr);

        // 2. Try finding `target` between 0 to `peakIndex`
        int targetIndex = binarySearch(mountainArr, 0, peakIndex - 1, target);
        if (targetIndex == -1) {
            targetIndex = binarySearchReverse(mountainArr, peakIndex, mountainArr.length() - 1, target);
        }
        return targetIndex;
    }

    public int getPeakIndex(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            int prev = mid == 0 ? Integer.MIN_VALUE : mountainArr.get(mid - 1);
            int curr = mountainArr.get(mid);
            int next = mid == mountainArr.length() - 1 ? Integer.MAX_VALUE : mountainArr.get(mid + 1);

            if (prev < curr && curr > next) {
                return mid;
            }

            if (prev < curr) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public int binarySearch(MountainArray mountainArr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchReverse(MountainArray mountainArr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
