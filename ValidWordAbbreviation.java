public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int lengthOfWord = word.length();
        int count = 0;
        int index = 0;
        while(index<abbr.length()){
            int digit = 0;
            while(index<abbr.length() && Character.isDigit(abbr.charAt(index))){
                if(abbr.charAt(index)=='0' && digit==0) return false;
                else{
                    digit = digit*10 + Integer.parseInt(abbr.charAt(index)+"");
                    index++;  
                }
            }
            count+=digit;
            if(index<abbr.length() && Character.isLetter(abbr.charAt(index))){
                if(count>=word.length()) return false;
                if(abbr.charAt(index)!=word.charAt(count)) return false;
                else{
                    count++;
                    index++;
                }
            }
        }
        return lengthOfWord==count;
    }
}
