/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/

public class Solution {
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i < sLen; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= Math.min(tLen, i); j++) {
                dp[i][j] = dp[i - 1][j];
                if (t.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[sLen][tLen];
    }
}
