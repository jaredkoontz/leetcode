package moveZeroes;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by jared on 10/26/15.
 */
public class moveZeroesTest {

    /*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].*/
    @Test
    public void test() {
        moveZeroes m = new moveZeroes();
        int[] arr = new int[]{0, 1, 0, 3, 12};
        m.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
