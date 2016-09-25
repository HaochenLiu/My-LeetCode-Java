public class Solution {
    public char findTheDifference(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        char t1 = 0;
        for(char c1:sArray)
            t1^=c1;
        for(char c2:tArray)
            t1^=c2;
        return(char)t1;
    }
}
