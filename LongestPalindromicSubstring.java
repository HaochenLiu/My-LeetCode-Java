/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

public class Solution {
    /** O(n) time and O(n) space cost. */
    public String preProcess(String s) {
        if(s.length() == 0)
            return "#";
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            result += "#" + s.charAt(i);
        }
        result += "#";
        return result;
    }

    public String longestPalindrome(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int center = 0, rightMost = 0;
        for(int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * center - i;
            P[i] = rightMost > i ? Math.min(rightMost - i, P[i_mirror]) : 0; 
            while(i + 1 + P[i] < n && i >= 1 + P[i] && T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }
            if(P[i] > center) {
                center = i;
                rightMost = i + center;
            }
        }
        int maxLen = 0, beginAt = 0;
        for(int i = 1; i < n - 1; i++) {
            if(maxLen < P[i]) {
                maxLen = P[i];
                beginAt = i;
            }
        }
        return s.substring((beginAt - maxLen) / 2, (beginAt - maxLen)/ 2 + maxLen);
    }
}
