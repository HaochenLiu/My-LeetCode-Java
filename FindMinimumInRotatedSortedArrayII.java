/*
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/

public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] == nums[start + 1] || nums[start] == nums[end])
                start++;
            else if (nums[end] == nums[end - 1])
                end--;
            else {
                int mid = start + (end - start) / 2;
                if (nums[mid] < nums[end])
                    end = mid;
                else 
                    start = mid + 1;
            }
        }
        return nums[start];
    }
}
