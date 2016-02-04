/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] occur = new boolean[128];
        int result = 0;
        for (int i = 0, j = 0; j < s.length(); i++) {
            for (; j < s.length() && !occur[s.charAt(j)]; j++) {
                occur[s.charAt(j)] = true;
            }
            result = Math.max(result, j - i);
            occur[s.charAt(i)] = false;
        }
        return result;
    }
}
