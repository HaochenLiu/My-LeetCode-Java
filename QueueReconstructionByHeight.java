public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people==null||people.length==0){
            int[][] res ={};
            return res;
        }
        MyComp mycomp = new MyComp();
        Arrays.sort(people, mycomp);
        int dup = 1;
        int[][] res = new int[people.length][people[0].length];
        for(int i=0;i<people.length;i++){
            res[i][0]=-1;
        }
        for(int i=0;i<people.length;i++){
            if(i>0){
                if(people[i][0]==people[i-1][0])
                    ++dup;
                else
                    dup=1;
            }
            int same = dup > 1 ? dup-1 : 0;
            // because of sorting based on the second element,
            // the latter people of the same height are always in latter positions, so -same
            int index = people[i][1]-same;
            for(int j=0;j<=index;j++){
                index+= res[j][0] == -1 ? 0:1;
            }
            if(res[index][0]==-1){
                ;
            }else{
                while(res[index][0]!=-1){
                    ++index;
                }
            }
            res[index][0]=people[i][0];
            res[index][1]=people[i][1];
  
        }
        return res;
    }
    
    static class MyComp implements Comparator<int[]>{
        public int compare(int[] arr1, int[] arr2){
            if(arr1[0]>arr2[0]){
                return 1;
            }else if(arr1[0]<arr2[0]){
                return -1;
            }else{
                if(arr1[1]==arr2[1]){
                    return 0;
                }else{
                    return arr1[1]>arr2[1] ? 1:-1;
                }
            }
        } 
    }
}
