/*
Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
*/

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new ArrayList<String>();
        int prev = lower - 1;
        for (int i=0; i<=nums.length; ++i) {
            int curr = (i==nums.length) ? upper + 1 : nums[i];
            if (curr - prev >= 2) {
                ranges.add(getRange(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return ranges;
    }
 
    private String getRange(int from, int to) {
        return (from==to) ? String.valueOf(from) : from + "->" + to;
    }
}
