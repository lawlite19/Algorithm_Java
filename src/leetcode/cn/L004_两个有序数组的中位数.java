package leetcode.cn;

import static java.lang.Integer.*;

public class L004_两个有序数组的中位数 {
    public static void main(String[] args) {
        double result;
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        result = findMedianSortedArrays(nums3, nums4);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l1 = 0, l2 = 0, r1 = 0, r2 = 0, c1, c2, low = 0, high = 2 * nums1.length;
        while (low <= high) {
            c1 = (low + high) >> 1;
            c2 = nums1.length + nums2.length - c1;
            l1 = (c1 == 0) ? MIN_VALUE : nums1[(c1 - 1) >> 1];
            r1 = (c1 == 2 * nums1.length) ? MAX_VALUE : nums1[c1 >> 1];

            l2 = (c2 == 0) ? MIN_VALUE : nums2[(c2 - 1) >> 1];
            r2 = (c2 == 2 * nums2.length) ? MAX_VALUE : nums2[c2 >> 1];
            if (l1 > r2) {
                high = c1 - 1;
            } else if (l2 > r1) {
                low = c1 + 1;
            } else {
                break;
            }
        }
        return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0d;
    }
}
