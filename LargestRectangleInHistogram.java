/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
*/

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;
        int i = 0;
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (i < heights.length || !stack.isEmpty()) {
            if (i < heights.length && (stack.isEmpty() || 
                        heights[i] >= heights[stack.peek()])) 
                stack.push(i++);
            else 
                res = Math.max(res, heights[stack.pop()] * 
                        (stack.isEmpty() ? i : i - stack.peek() - 1));
        }
        return res;
    }
}
