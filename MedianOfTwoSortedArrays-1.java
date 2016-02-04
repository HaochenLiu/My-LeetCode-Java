/*
There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;
        while (idx1 < nums1.length || idx2 < nums2.length) {
            if (idx1 < nums1.length && idx2 < nums2.length)
                nums3[idx3++] = nums1[idx1] < nums2[idx2] ? nums1[idx1++] : nums2[idx2++];
            else if (idx1 < nums1.length) 
                nums3[idx3++] = nums1[idx1++];
            else 
                nums3[idx3++] = nums2[idx2++];
        }
        double result = nums3[nums3.length / 2];
        if (nums3.length % 2 == 0) 
            result = (result + nums3[nums3.length / 2 - 1]) / 2;
        return result;
    }
}
