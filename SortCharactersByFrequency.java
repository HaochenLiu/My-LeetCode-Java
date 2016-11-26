public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            Integer freq = map.getOrDefault(c, 0);
            map.put(c, freq+1);
        }
        Tuple[] tuples = new Tuple[map.size()];
        int i=0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            tuples[i] = new Tuple(entry.getKey(), entry.getValue());
            i++;
        }
        Arrays.sort(tuples);
        StringBuilder sb = new StringBuilder();
        for(Tuple tup : tuples){
            for(int t=0; t<tup.freq; t++){
                sb.append(tup.c);
            }
        }
        return sb.toString();
    }
    
    class Tuple implements Comparable<Tuple>{
        char c;
        int freq;
        Tuple(char c, int freq){
            this.c = c;
            this.freq = freq;
        }
        @Override
        public int compareTo(Tuple tup){
            return tup.freq-freq;
        }
    }    
}
