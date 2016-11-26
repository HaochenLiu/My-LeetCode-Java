public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> result = new ArrayList<Integer>(nums.length);
        int indx = 0, abs_n = 0;
        for(int n : nums) {
            abs_n = Math.abs(n);
            indx = abs_n - 1;
            if(nums[indx] > 0)
                nums[indx] *= -1;
            else
                result.add(abs_n);
        }
        
        return result;
    }
}
