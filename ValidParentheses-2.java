/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() || stack.peek() == '(' && c != ')' || 
                        stack.peek() == '[' && c != ']' || 
                        stack.peek() == '{' && c != '}') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
