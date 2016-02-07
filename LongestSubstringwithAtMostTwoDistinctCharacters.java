/*
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.
*/

public class Solution {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int left = 0, right = 0, len = s.length(), maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < len) {
            char rightChar = s.charAt(right);
            if (map.get(rightChar) != null)
                map.put(rightChar, map.get(rightChar) + 1);
            else if (map.get(rightChar) == null && map.size() < 2)
                map.put(rightChar, 1);
            else if (map.get(rightChar) == null && map.size() == 2) {
                while (map.size() == 2) {
                    char leftChar = s.charAt(left);
                    int count = map.get(leftChar);
                    count--;
                    if (count == 0) {
                        map.remove(leftChar);
                    } else
                        map.put(leftChar, count);
                    left++;
                }
                map.put(rightChar, 1);
            }
            maxLen = Integer.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}

