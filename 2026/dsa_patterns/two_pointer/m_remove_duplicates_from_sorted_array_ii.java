// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int slow = 2;
        int fast = 2;

        while (fast < nums.length) {
            // Most tricky part is is this if condition where we compare fast with slow-2 and not with fast-2
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
/* Learning:
Not to underestimate any Q, this fealt easy but was so tricky
*/
