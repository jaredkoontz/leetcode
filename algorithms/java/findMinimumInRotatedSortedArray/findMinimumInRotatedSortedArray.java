// Source : https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Inspired by : http://www.jiuzhang.com/solutions/find-minimum-in-rotated-sorted-array/
// Author : Lei Cao
// Date   : 2014-10-05

/**********************************************************************************
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 **********************************************************************************/

package findMinimumInRotatedSortedArray;

public class findMinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return Integer.MIN_VALUE;
        }

        int start = 0;
        int end = num.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[start] < num[end]) {
                end = mid;
            } else if (num[start] < num[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (num[start] < num[end]) {
            return num[start];
        } else {
            return num[end];
        }
    }


    /*The minimum element must satisfy one of two conditions: 1) If rotate, A[min] < A[min - 1]; 2) If not, A[0].
    Therefore, we can use binary search: check the middle element, if it is less than previous one, then it is minimum.
    If not, there are 2 conditions as well: If it is greater than both left and right element, then minimum element
    should be on its right, otherwise on its left.*/


        public int findMin2(int[] num) {
            if (num == null || num.length == 0) {
                return 0;
            }
            if (num.length == 1) {
                return num[0];
            }
            int start = 0, end = num.length - 1;
            while (start < end) {
                int mid = (start + end) / 2;
                if (mid > 0 && num[mid] < num[mid - 1]) {
                    return num[mid];
                }
                if (num[start] <= num[mid] && num[mid] > num[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return num[start];
        }


}
