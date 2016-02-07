/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
*/

public class Solution {
    public int trap(int[] height) {
        int result = 0;
        int start = 0;
        int end = height.length;
        int leftMax = 0;
        int rightMax = 0;
        while (start < end) {
            if (leftMax < rightMax) {
                result += Math.max(leftMax - height[start], 0);
                leftMax = Math.max(leftMax, height[start++]);
            } else {
                result += Math.max(rightMax - height[--end], 0);
                rightMax = Math.max(rightMax, height[end]);
            }
        }
        return result;
    }
}
