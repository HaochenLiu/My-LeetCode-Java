/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        result.add(new ArrayList<Integer>());
        int oldSize = 0;
        for (int i = 0; i < nums.length; i++) {
            int newSize = result.size();
            int start = (i > 0 && nums[i] != nums[i - 1]) ? 0 : oldSize;
            for (int j = start; j < newSize; j++) {
                List<Integer> list = new ArrayList<Integer>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
            oldSize = newSize;
        }
        return result;
    }
}
