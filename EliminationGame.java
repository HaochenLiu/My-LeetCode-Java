public class Solution {
    public int lastRemaining(int n) {
        if (n == 1) return 1;
        if (n <= 3) return 2;
        return 4 * lastRemaining(n/4) - 2 + 2 * ((n % 4) /2);
    }
}
