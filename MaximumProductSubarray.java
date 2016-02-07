/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution {
    public int maxProductHelper(int[] nums, int start, int end) {
        if (start == end)
            return nums[start];
        int negNum = 0;
        int product = 1;
        for (int i = start; i <= end; i++) {
            product *= nums[i];
            if (nums[i] < 0) {
                negNum += 1;
            }
        }
        if (negNum % 2 == 1) {
            int temp1 = 1;
            int temp2 = 1;
            for (int i = start; ; i++) {
                temp1 *= nums[i];
                if (nums[i] < 0)
                    break;
            }
            for (int i = end; ; i--) {
                temp2 *= nums[i];
                if (nums[i] < 0)
                    break;
            }
            product /= (temp1 < temp2 ? temp2 : temp1);
        }
        return product;
    }

    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int start = 0; 
        for (int i = 0; i < nums.length; i++) {  
            if (nums[i] == 0) {
                maxProduct = Math.max(0, maxProduct);
                if (i >= 1)
                    maxProduct = Math.max(maxProduct, maxProductHelper(nums, start, i - 1));
                while (i < nums.length - 1 && nums[i] == 0 && nums[i + 1] == 0) {
                    i++;
                }
                start = i + 1;
            } else if (i == nums.length - 1) {
                maxProduct = Math.max(maxProduct, maxProductHelper(nums, start, i));
            } 
        }
        return maxProduct;
    }
}
