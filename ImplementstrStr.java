/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0, k = i; j < needle.length() && k < haystack.length() 
                    && needle.charAt(j) == haystack.charAt(k); j++, k++) {
                if (j == needle.length() - 1)
                    return i;
            }
        }
        return -1;
    }
}
