/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < 1 << nums.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & 1 << j) != 0)
                    list.add(nums[j]);
            }
            result.add(list);
        }
        return result;
    }
}
