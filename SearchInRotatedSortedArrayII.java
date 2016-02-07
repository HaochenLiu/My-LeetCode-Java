/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/

public class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            while (start < end && nums[end] == nums[end - 1])
                end--;
            int mid = start + (end - start) / 2;
            if (target == nums[mid])
                return true;
            else if (target < nums[mid]) {
                if (nums[mid] >= nums[end] && target < nums[start])
                    start = mid + 1;
                else 
                    end = mid - 1;
            } else {                
                if (nums[mid] < nums[end] && target > nums[end])
                    end = mid - 1;
                else 
                    start = mid + 1;
            }
        }
        return false;
    }
}
