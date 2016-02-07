/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.
*/

public class Solution {
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < gcd(nums.length, k); i++) {
            int tmp = nums[i];
            int j = i;
            while (true) {
                int p = (j + nums.length - k % nums.length) % nums.length;
                if (p == i)
                    break;
                nums[j] = nums[p];
                j = p;
            }
            nums[j] = tmp;
        }
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp % a;
        }
        return a;
    }
}
