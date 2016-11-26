public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(bank==null||bank.length==0)
        return -1;
        
        Set<String> bank1 = new HashSet<>();
        for(String s : bank)
        bank1.add(s);
        if(!bank1.contains(end))
        return -1;
        
        char[] gene = new char[]{'A','C','G','T'};
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        
        set1.add(start);
        set2.add(end);
        
        
        int count=0;
        while(!set1.isEmpty()&&!set2.isEmpty()){
            if(set1.size()>set2.size()){
                Set<String> t=set1;
                set1=set2;
                set2=t;
            }
            Set<String> temp = new HashSet<>();
            
            for(String s : set1){
                char[] arr = s.toCharArray();
                for(int i=0;i<arr.length;i++){
                    char old=arr[i];
                    for(int j=0;j<gene.length;j++){
                        if(gene[j]==old)
                        continue;
                        arr[i]=gene[j];
                        String candi = String.valueOf(arr);
                        if(set2.contains(candi))
                        return count+1;
                        if(bank1.contains(candi)){
                        temp.add(candi);
                        bank1.remove(candi);
                        }
                        arr[i]=old;
                    }
                }
            }
            count++;
            set1=temp;
        }
        return -1;
    }
}
