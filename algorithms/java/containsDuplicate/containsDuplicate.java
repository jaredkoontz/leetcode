package containsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//todo
public class containsDuplicate {
    /*This problem seems trivial, so lets try different approaches to solve it:

    Starting from worst time complexity to the best one:

    Time complexity: O(N^2), memory: O(1)

    The naive approach would be to run a iteration for each element and see whether a duplicate value can be found: this results in O(N^2) time complexity.*/

    public boolean containsDuplicate1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /*Time complexity: O(N lg N), memory: O(1) - not counting the memory used by sort

    Since it is trivial task to find duplicates in sorted array, we can sort it as the first step of the algorithm and then search for consecutive duplicates.
*/
    public boolean containsDuplicate2(int[] nums) {

        Arrays.sort(nums);
        for (int ind = 1; ind < nums.length; ind++) {
            if (nums[ind] == nums[ind - 1]) {
                return true;
            }
        }
        return false;
    }

    /* Time complexity: O(N), memory: O(N)

     Finally we can used a well known data structure hash table that will help us to identify whether an element has been previously encountered in the array.
 */
    public boolean containsDuplicate3(int[] nums) {

        final Set<Integer> distinct = new HashSet<Integer>();
        for (int num : nums) {
            if (distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }

}
