/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

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
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> result = new ArrayList<Interval>();
        for (int i = 0; i < intervals.size(); i++) {
            if (i > 0 && intervals.get(i).start <= 
                    result.get(result.size() - 1).end)
                result.get(result.size() - 1).end = Math.max(result.
                        get(result.size() - 1).end, intervals.get(i).end);
            else
                result.add(intervals.get(i));
        } 
        return result;
    }

    class IntervalComparator implements Comparator<Interval> {
    
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }

    }
}
