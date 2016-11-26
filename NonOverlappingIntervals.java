/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] A) {
        if(A == null || A.length == 0) return 0;
        Arrays.sort(A, new Comparator<Interval> () {
           public int compare(Interval a, Interval b) {
               return Integer.compare(a.start, b.start);
           } 
        });
        int rst = 0;
        Interval tail = A[0];
        for(int i = 1; i < A.length; ++i) {
            if(A[i].start >= tail.end) tail = A[i];
            else {
                rst++;
                if(A[i].end < tail.end) tail = A[i];
            }
        }
        return rst;
        
    }
}
