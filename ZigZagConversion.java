/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        String res = "";
        int len = s.length();
        int T = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; i + j * T < len; j++) {
                res += s.charAt(i + j * T);
                if (i > 0 && i < numRows - 1 && (T - i + j * T < len))
                    res += s.charAt(T - i + j * T);
            }
        }
        return res;
    }
}