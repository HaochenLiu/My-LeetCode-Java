/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

public class Solution {
	// time: O(n); space: O(n)
    public int longestConsecutive(int[] num) {
        int result = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int value : num) {
            set.add(value);
        }
        for (int value : num) {
            int low = value;
            int high = value + 1;
            while (set.contains(low - 1)) {
                set.remove(low--);
            }
            while (set.contains(high)) {
                set.remove(high++);
            }
            result = Math.max(result, high - low);
        }
        return result;
    }
}
