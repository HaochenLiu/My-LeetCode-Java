/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    public String intToRoman(int num) {
        String result = "";
        String[] roman = {"I", "V", "X", "L", "C", "D", "M"};
        int i = 0; 
        while (num > 0) {
            int lowBit = num % 10;
            if (lowBit == 4 || lowBit == 9)
                result = roman[2 * i] + (lowBit == 4 ? roman[2 * i + 1] : 
                        roman[2 * i + 2]) + result;
            else {
                for (int j = 0; j < lowBit % 5; j++) 
                    result = roman[2 * i] + result;
                if (lowBit >= 5)
                    result = roman[2 * i + 1] + result;
            }
            num /= 10;
            i++;
        }
        return result;
    }
}
