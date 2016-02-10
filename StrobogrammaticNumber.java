/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
*/

public class Solution {
    public static boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0)
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        int low = 0, high = num.length() - 1;
        while (low <= high) {
            if (map.get(num.charAt(low)) == null || map.get(num.charAt(low)) != num.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}
