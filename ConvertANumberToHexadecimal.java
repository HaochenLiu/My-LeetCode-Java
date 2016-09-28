public class Solution {
    public String toHex(int num) {
        return num == 0 ? "0" : toHex(num & 0xffffffffL);
    }
    
    public String toHex(long num) {
        return num < 16 ? hexdigit(num) : toHex(num / 16) + hexdigit(num % 16);
    }
    
    private String hexdigit(long num) {
        assert num < 16;
        return num < 10 ? Character.toString((char)(num + '0')) : Character.toString((char)(num - 10 + 'a'));
    }
}
