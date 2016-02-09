/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases. Thanks to @Freezen for additional test cases.
*/

public class Solution {
    public String shortestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int i = len - 1;
        for (; i >= 0; --i) {
            if (isPalindrome(s, 0, i)) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder(s.substring(i + 1));
        sb.reverse().append(s);
        return sb.toString();
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
