// https://leetcode.com/problems/reverse-string/description/

class Solution {
    public void reverseString(char[] s) {
        if (s.length <= 1) return; // EDGE CASE

        int left = 0;
        int right = s.length-1; // NOTE: It should be s.length-1 and NOT s.length

        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
    //TC: O(n)
    //SC: O(1)
}

