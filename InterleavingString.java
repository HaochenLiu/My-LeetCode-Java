/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3) return false;
        if (n2 > n1) {
            String tmp = s1; s1 = s2; s2 = tmp;
            int n = n1; n1 = n2; n2 = n;
        }
        boolean cando[] = new boolean[n2+1];
        cando[0] = true;
        for (int j = 1; j <= n2; ++j)
            cando[j] = cando[j-1] && s3.charAt(j-1) == s2.charAt(j-1);
        for (int i = 1; i <= n1; ++i) {
            cando[0] = cando[0] && s3.charAt(i-1) == s1.charAt(i-1);
            for (int j = 1; j <= n2; ++j) {
                char c = s3.charAt(i + j - 1);
                cando[j] = (cando[j] && c == s1.charAt(i-1)) || (cando[j-1] && c == s2.charAt(j-1));
            }
        }
        return cando[n2];
    }
}
