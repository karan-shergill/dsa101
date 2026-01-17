// https://leetcode.com/problems/adding-spaces-to-a-string/description/

class Solution {
    public String addSpaces(String s, int[] spaces) {
        char[] charArray = new char[s.length() + spaces.length];
        int p2 = 0;
        int p3 = 0;
        for (int p1 = 0; p1 < s.length(); p1++) {
            if (p2 < spaces.length && p1 == spaces[p2]) {
                charArray[p3++] = ' ';
                p2++;
            }
            charArray[p3++] = s.charAt(p1);
        }

        return String.valueOf(charArray);
    }
}
