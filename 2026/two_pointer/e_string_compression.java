// https://leetcode.com/problems/string-compression/description/

// Approch 2

class Solution {

    public int compress(char[] chars) {
        char lastChar = chars[0];
        int count = 0;
        String str = "";

        int p2 = 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == lastChar) {
                count++;
            } else {
                if (count == 0) {
                    chars[p2++] = lastChar;
                } else {
                    chars[p2++] = lastChar;
                    str = "" + (count + 1);
                    for (int j = 0; j < str.length(); j++) {
                        chars[p2++] = str.charAt(j);
                    }
                }

                lastChar = chars[i];
                count = 0;
            }
        }

        if (count == 0) {
            chars[p2++] = lastChar;
        } else {
            chars[p2++] = lastChar;
            str = "" + (count + 1);
            for (int j = 0; j < str.length(); j++) {
                chars[p2++] = str.charAt(j);
            }
        }

        return p2;
    }
}

// Approch 1

class Solution {

    public int compress(char[] chars) {
        char lastChar = chars[0];
        int count = 0;
        String str = "";

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == lastChar) {
                count++;
            } else {
                if (count == 0) {
                    str += lastChar;
                } else {
                    str += lastChar + "" + (count + 1);
                }

                lastChar = chars[i];
                count = 0;
            }
        }

        if (count == 0) {
            str += lastChar;
        } else {
            str += lastChar + "" + (count + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }

        return str.length();
    }
}
