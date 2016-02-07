/*
Given two strings S and T, determine if they are both one edit distance apart.
*/

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        char[] longer = s.length()>t.length()?s.toCharArray():t.toCharArray();
        char[] shorter = s.length()>t.length()?t.toCharArray():s.toCharArray();
    
        if(longer.length - shorter.length > 1) return false;
    
        int cnt = 0;
    
        int i = 0, j = 0;
        while(true) {
            while (j < shorter.length && longer[i] == shorter[j]) {
                ++i;
                ++j;
            }
    
            if (j == shorter.length) return !(cnt == 0) || longer.length-shorter.length==1;
            if (++cnt > 1) return false;
    
            // same length, replace
            if (longer.length == shorter.length) {
                ++i;
                ++j;
            } else { //delete from longer
                ++i;
            }
        }
    }
}
