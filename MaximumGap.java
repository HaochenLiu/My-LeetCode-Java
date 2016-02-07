/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

Credits:
Special thanks to @porker2008 for adding this problem and creating all test cases.
*/

public class Solution {
    // O(n) 
    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int value : nums) {
            maxValue = Math.max(maxValue, value);
            minValue = Math.min(minValue, value);
        }
        if(maxValue == minValue) return 0;
        double w = (double) (maxValue - minValue) / (nums.length + 1);
        int[][] bucket = new int[2][nums.length + 1];
        Arrays.fill(bucket[0], minValue);
        Arrays.fill(bucket[1], maxValue);
        for (int value : nums) {
            int k = (int) Math.floor((value - minValue) / w);
            if (k == nums.length + 1)
                k--;
            bucket[0][k] = Math.max(bucket[0][k], value);
            bucket[1][k] = Math.min(bucket[1][k], value);
        }
        int result = Integer.MIN_VALUE;
        for (int i = 1, j = 0; i < nums.length + 1; i++) {
            if (bucket[0][i] != minValue) {
                result = Math.max(result, bucket[1][i] - bucket[0][j]);
                j = i;
            }
        }
        return result;
    }
}
