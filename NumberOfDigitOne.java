/*
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

Hint:

Beware of overflow.
*/

public class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        int last = 0;
        for (long i = 1; i <= n; i *= 10) {
            int digit = (int) (n / i) % 10;
            count += digit * last;
            if (digit > 1)
                count += i;
            else if (digit == 1)
                count += n % i + 1;
            last = (int) (last * 10 + i);
        }
        return count;
    }
}
