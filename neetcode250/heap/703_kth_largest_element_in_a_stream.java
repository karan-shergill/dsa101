// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

class KthLargest {
    PriorityQueue<Integer> minHeap;
    int maxSize;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        maxSize = k;

        for (int val : nums) {
            minHeap.add(val);

            if (minHeap.size() > maxSize) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > maxSize) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    // TC: O(nlogk)
    // SC: O(k)
}

/* Learning
1. Kth Largest element - use Min Heap
2. Kth Smallest element - use Max Heap
3. 1st add the new value in heap and then reduce the size
*/
