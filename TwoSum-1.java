/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(m.get(target - nums[i]) != null) {
                return new int[] {m.get(target - nums[i]) + 1, i + 1};
            } else {
                m.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}
