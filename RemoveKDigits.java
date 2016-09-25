public class Solution {
    public String removeKdigits(String num, int k) {
        if(k == 0) return num; 
        Deque<Character> stack = new ArrayDeque();
        int count = 0;
        for(int i=0; i<num.length(); i++){
            char c = num.charAt(i);
            while(count < k && !stack.isEmpty() && c < stack.peek()){
                stack.pop(); 
                count++;
            }
            stack.push(c);
        }
        while(count++ < k) stack.pop();
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        String rlt = removeZero(sb.toString());
        return rlt.length() == 0?"0":rlt;
    }
    
    public String removeZero(String str){
        return str.replaceFirst("^0+","");      //remove preceding 0s
    }
}
