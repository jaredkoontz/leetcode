package twoSum;

// Source : https://oj.leetcode.com/problems/two-sum/
// Author : Hao Chen / Jared Koontz
// Date   : 2014-06-17 / 10/23/15

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**********************************************************************************
 *
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
 * are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 *
 **********************************************************************************/

public class TwoSum {
      /*
     *   The easy solution is O(n^2) run-time complexity.
     *   ```
     *       foreach(item1 in array) {
     *           foreach(item2 in array){
     *               if (item1 + item2 == target) {
     *                   return result
     *               }
     *           }
     *   ```
     *
     *   We can see the nested loop just for searching,
     *   So, we can use a hashmap to reduce the searching time complexity from O(n) to O(1)
     *   (the map's `key` is the number, the `value` is the position)
     *
     *   But be careful, if there are duplication numbers in array,
     *   how the map store the positions for all of same numbers?
     *
     */


    //
    // The implementation as below is bit tricky. but not difficult to understand
    //
    //  1) Traverse the array one by one
    //  2) just put the `target - num[i]`(not `num[i]`) into the map
    //     so, when we checking the next num[i], if we found it is existed in the map.
    //     which means we found the second one.
    //

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }

    public static void main(String[] a){
        int [] numbers= new int[] {2, 7, 11, 15};
        int target=9;
        TwoSum s = new TwoSum();
        System.out.println(Arrays.toString(s.twoSum(numbers, target)));
    }
}
