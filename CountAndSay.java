/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++) {
            String next = result; 
            result = "";
            int count = 1;
            for (int j = 1; j < next.length(); j++) {
                if (next.charAt(j) == next.charAt(j - 1))
                    count++;
                else {
                    result += "" + count + next.charAt(j - 1);
                    count = 1;
                }
            }
            result += "" + count + next.charAt(next.length() - 1);
        }
        return result;
    }
}
