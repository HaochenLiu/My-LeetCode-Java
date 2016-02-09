/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.
*/

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<Integer>(), 1, k, n);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, 
            int position, int k, int n) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = position; i <= 9 && n > 0; ++i) {
            list.add(i);
            dfs(result, list, i + 1, k - 1, n - i);
            list.remove(list.size() - 1);
        }
    }
}
