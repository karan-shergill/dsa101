// https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

// This problem is same as https://leetcode.com/problems/split-array-largest-sum/description/

class Solution {
    public static int findPages(int[] arr, int K) {
        // code here
        
        if (arr.length < K) return -1;
        
        int totalPages = 0, maxPages1Book = 0;
        for (Integer val : arr) {
            totalPages += val;
            maxPages1Book = Math.max(maxPages1Book, val);
        }
        
        int start = maxPages1Book;
        int end = totalPages;
        int ans = -1;
        
        while (start <= end) {
            int mid = start + ((end - start)/2);
            
            if (isPossibleToAllocateMidPagesToKStudents(arr, K, mid)) {
                ans = mid;
                //minimize pages
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    
    public static boolean isPossibleToAllocateMidPagesToKStudents(int[] arr, int K, int mid) {
        int studCount = 1;
        int currPages = 0;
        for (Integer val : arr) {
            currPages += val;
            if (currPages > mid) {
                studCount++;
                currPages = val;
            }
        }
        
        return studCount <= K;
    }
}
