/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        dfs(result, "", n, n);
        return result;
    }

    public void dfs(List<String> list, String s, int left, int right) {
        if (left < 0 || left > right)
            return;
        if (left == 0 && right == 0)
            list.add(s);
        dfs(list, s + "(", left - 1, right);
        dfs(list, s + ")", left, right - 1);
    }
}
