// https://leetcode.com/problems/contains-duplicate/description/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int val: nums) {
            if (set.contains(val)) {
                return true;
            }
            set.add(val);
        }
        return false;
    }
    //TC: O(n)
    //SC: O(n)
}

/*
Learning:
1. Another approch was sort and compre to find duplicate, it has TC: O(nlogn) and SC: O(1)
2. Annother approch could be HashMap, but in that case .contains() time complexity is O(n) in worst case
*/
