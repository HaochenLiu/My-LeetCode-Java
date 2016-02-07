/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0)
            result.add("");
        else if (n == 1)
            result.add("()");
        else {
            for (int i = 0; i < n; i++) {
                for (String inner : generateParenthesis(i)) {
                    for (String outer : generateParenthesis(n - 1 - i)) {
                        result.add("(" + inner + ")" + outer);
                    }
                }
            }
        }
        return result;
    }
}
