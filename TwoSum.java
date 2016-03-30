/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(m.get(target - nums[i]) != null) {
                return new int[] {m.get(target - nums[i]), i};
            } else {
                m.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}
