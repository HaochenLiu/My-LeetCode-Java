public class Solution {
    public String decodeString(String s) {
        return decode("1[" + s + "]", 0);
    }
    
    // only for one level
    private String decode(String s, int start) { // s.charAt(start) cannot be 
        
        if(start >= s.length()) {
            return "";
        }
        int idx = start;
        
        if(!Character.isDigit(s.charAt(idx))) {// s.charAt(idx) is a letter
            return s.charAt(idx) + decode(s, idx+1);
        }
        
        if(Character.isDigit(s.charAt(idx))) {// s.charAt(idx) is a digit
            while(Character.isDigit(s.charAt(idx))) {
                idx++;
            } //s.charAt(idx) == '['            
        }
        
        int times = Integer.valueOf(s.substring(start, idx));
        String str = ""; // to be repeated
        int startIdx = idx+1;
        
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(idx));
        while(!stack.empty()) {
            idx++;
            if(s.charAt(idx) == ']') {
                stack.pop();
            } else if(s.charAt(idx) == '[') {
                stack.push(s.charAt(idx));
            }
        }// s.charAt(idx) == ']'
        
        str += decode(s.substring(startIdx, idx), 0);
        
        String res = "";
        for(int i = 0; i < times; i++) {
            res += str;
        }
        
        return res + decode(s, idx+1);
    }
}
