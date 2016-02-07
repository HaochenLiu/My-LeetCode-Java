/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

public class Solution {
    public int mySqrt(int x) {
        int start = 1;
        int end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid)
                return mid;
            else if (mid < x / mid)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return (start + end) / 2;
    }
}
