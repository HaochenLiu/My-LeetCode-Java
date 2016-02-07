/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Credits:
Special thanks to @ts for adding this problem and creating all test case
*/

public class Solution {
    public int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;
        for (int value : nums) {
            count += value == result ? 1 : -1;
            if (count <= 0) {
                result = value;
                count = 1;
            }
        }
        return result;
    }
}
