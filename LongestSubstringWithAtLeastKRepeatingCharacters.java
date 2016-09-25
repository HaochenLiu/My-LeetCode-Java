public class Solution {
    public int longestSubstring(String s, int k) {
        char[] schar=s.toCharArray();
        return longest(schar,0,schar.length-1,k);
    }
    public int longest(char[] schar,int start,int end,int k){
        if(end-start+1<k){
            return 0;
        }
        Map<Character,List<Integer>> map=new HashMap<Character,List<Integer>>();
        for(int i=start;i<=end;i++){   //count hwo many times each characters appears
            if(!map.containsKey(schar[i])){
                List<Integer> newlist=new ArrayList<Integer>();
                map.put(schar[i],newlist);
            }
            map.get(schar[i]).add(i);
        }
        List<Integer> less=new ArrayList<Integer>();
        for(char c:map.keySet()){
            if(map.get(c).size()<k){
                less.addAll(map.get(c));
            }
        }
        if(less.size()==0){
            return end-start+1;
        }
        int max=0;
        Collections.sort(less);
        less.add(end+1);
        int last=start-1;
        for(int i=0;i<less.size();i++){               //divide the string into substrirng
            int cur=less.get(i);
            max=Math.max(max,longest(schar,last+1,cur-1,k));
            last=cur;
        }
        return max;
    }
}
