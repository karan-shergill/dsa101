// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/

class Solution {
    public int appendCharacters(String s, String t) {
        // Let's try 2 pointer

        int index1 = 0;
        int index2 = 0;

        while(index1 < s.length() && index2 < t.length()) {
            if (s.charAt(index1) == t.charAt(index2)) {
                index1++;
                index2++;
            } else {
                index1++;
            }
        }

        return t.length() - index2;
    }
}
