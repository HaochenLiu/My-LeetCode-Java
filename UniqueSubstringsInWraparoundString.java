public class Solution {
    public int findSubstringInWraproundString(String p) {
        if(p == null || p.isEmpty()) return 0;
        int dp[] = new int[26];
        int i = 0;
        int n = p.length();
        char [] s = p.toCharArray();
        int len = 1;
        while(i<n){
            char prev = s[i];
            i++;
            dp[prev - 'a'] = Math.max(dp[prev-'a'], len);
            while(i<p.length() && s[i]-'a' == (prev-'a'+1)%26){
                prev = s[i];
                len++;
                i++;
                dp[prev - 'a'] = Math.max(dp[prev-'a'], len);
            }
            dp[prev - 'a'] = Math.max(dp[prev-'a'], len);
            len = 1;
        }
        int count = 0;
        for(int j = 0;j<26;j++) count+=dp[j];
        return count;
    }
}
