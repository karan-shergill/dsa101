// https://leetcode.com/problems/maximum-number-of-removable-characters/description/

class Solution {

    public int maximumRemovals(String s, String p, int[] removable) {
        int start = 0;
        int end = removable.length - 1;
        int pAns = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            String newS = getUpdatedString(s, removable, mid);

            if (isSubsequence(newS, p)) {
                pAns = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // EDGE CASE: pAns + 1 as we need to return count of index to remove staring left of removable[]
        return pAns == -1 ? 0 : pAns + 1;
    }

    private boolean isSubsequence(String s, String p) {
        if (p.length() > s.length()) {
            return false;
        }

        int p1 = 0;
        int p2 = 0;

        while (p1 < s.length()) {
            if (s.charAt(p1) == p.charAt(p2)) {
                p2++;
            }

            if (p2 == p.length()) {
                return true;
            }
            p1++;
        }

        return false;
    }

    private String getUpdatedString(String s, int[] removable, int indexTill) {
        char[] chars = s.toCharArray();

        for (int i = 0; i <= indexTill; i++) {
            chars[removable[i]] = '*';
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '*') {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }
}
