/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Note: For the return value, each inner list's elements must follow the lexicographic order.
*/

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strings == null || strings.length == 0)
            return result;
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < s.length(); j++)
                stringBuffer.append((s.charAt(j) - s.charAt(0) + 26) % 26 + " ");
    
            if (map.get(stringBuffer.toString()) == null) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(stringBuffer.toString(), list);
            } else {
                map.get(stringBuffer.toString()).add(s);
            }
        }
        for (String s : map.keySet()) {// 对map进行遍历
            List<String> list = map.get(s);
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
}
