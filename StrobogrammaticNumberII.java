/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].

Hint:

Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
*/

public class Solution {
    public static final char[][] chs = {{'6', '9'}, {'9', '6'}, {'1', '1'}, {'8', '8'}, {'0', '0'}};
    
    public static List<String> findStrobogrammatic(int n) {
        return findHelper(n, n);
    }
    
    public static ArrayList<String> findHelper(int num, int n) {
        if (num == 1)  return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        if (num <= 0)  return new ArrayList<String>(Arrays.asList(""));
        List<String> list = findHelper(num - 2, n);
        int to = (num == n ? 3 : 4);
        ArrayList<String> newList = new ArrayList<String>();
        for (String str : list) {
            for (int i = 0; i <= to; i++)
                newList.add(chs[i][0] + str + chs[i][1]);
        }
        list = null;
        return newList;
    }
}
