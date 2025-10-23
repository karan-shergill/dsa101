// https://leetcode.com/problems/last-stone-weight/description/

class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int val: stones) {
            maxHeap.add(val);
        }

        while (maxHeap.size() > 1) {
            int heaviest1 = maxHeap.poll();
            int heaviest2 = maxHeap.poll();

            if (heaviest1 == heaviest2) {
                continue;
            }
            maxHeap.add(heaviest1 - heaviest2);
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
    // TC: O(nlogn)
    // SC: O(n)
}

/* Learning
1. Need to use Collections.reverseOrder() for Max Heap
*/
