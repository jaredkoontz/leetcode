package twoSumSorted;

// Source : https://oj.leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// Author : Hao Chen / Jared Koontz
// Date   : 2014-06-17 / 10/23/15

import java.util.Arrays;

/**********************************************************************************
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p/>
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
 * are not zero-based.
 * <p/>
 * You may assume that each input would have exactly one solution.
 * <p/>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 **********************************************************************************/

public class TwoSumSorted {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            if (numbers[low] + numbers[high] == target) {
                result[0] = (low + 1);
                result[1] = (high + 1);
                return result;
            } else {
                if (numbers[low] + numbers[high] > target)
                    high--;
                else
                    low++;
            }
        }

        return result;
    }


    public static void main(String[] a) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        TwoSumSorted s = new TwoSumSorted();
        System.out.println(Arrays.toString(s.twoSum(numbers, target)));
    }
}
