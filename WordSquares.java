public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> list = new ArrayList<List<String>>();
        int len1 = words.length;
        int len2 = words[0].length();
        HashMap<Character, List<String>> hm = new HashMap<Character, List<String>>();
        for(int i=0; i<len1; i++) {
            char c = words[i].charAt(0);
            List<String> l = new ArrayList<String>();
            if(hm.containsKey(c)) {
                l = hm.get(c);
            }
            l.add(words[i]);
            hm.put(c, l);
        }
        for(int i=0; i<len1; i++) {
            String[] curr = new String[len2];
            curr[0] = words[i];
            helper(1, curr, hm, len2, list);
        }
        return list;
    }
    public void helper(int index, String[] curr, HashMap<Character, List<String>> hm, int len2, List<List<String>> list) {
        if(index==len2) {
            list.add(new ArrayList<String>(Arrays.asList(curr)));
            return;
        }
        char x = curr[0].charAt(index);
        if(!hm.containsKey(x))   return;
        for(String str : hm.get(x)) {
            if(matches(str, index, curr)) {
                curr[index] = str;
                helper(index+1, curr, hm, len2, list);
            }
        }
    }
    public boolean matches(String str, int end, String[] curr) {
        for(int i=1; i<end; i++) {
            if(str.charAt(i)!=curr[i].charAt(end))  return false;
        }
        return true;
    }
}
