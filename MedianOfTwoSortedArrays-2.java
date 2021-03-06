/*
There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int aLen = nums1.length;
        int bLen = nums2.length;
        if ((aLen + bLen) % 2 == 1)
            return findKth(nums1, 0, aLen - 1, nums2, 0, bLen - 1, (aLen + bLen) / 2);
        else
            return (findKth(nums1, 0, aLen - 1, nums2, 0, bLen - 1, 
                        (aLen + bLen) / 2) + findKth(nums1, 0, aLen - 1, 
                            nums2, 0, bLen - 1, (aLen + bLen) / 2 - 1)) / 2;
    }

    public double findKth(int[] nums1, int aStart, int aEnd, 
            int[] nums2, int bStart, int bEnd, int k) {
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;
        if (aLen == 0)
            return nums2[bStart + k];
        if (bLen == 0)
            return nums1[aStart + k];
        if (k == 0)
            return Math.min(nums1[aStart], nums2[bStart]);
        int aMid = aStart + aLen * k / (aLen + bLen);
        int bMid = bStart + k - aLen * k / (aLen + bLen) - 1;
        if (nums1[aMid] > nums2[bMid]) {
            k -= (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k -= (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }
        return findKth(nums1, aStart, aEnd, nums2, bStart, bEnd, k);
    }
}
