package climbStairs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * Created by leicao & jared on 10/23/15
 */
public class ClimbStairsTest {
    @Test
    public void testStairs(){
        ClimbStairs climbStairs = new ClimbStairs();

        System.out.println(climbStairs.climbStairs(2));
        System.out.println(climbStairs.climbStairs(21));
        System.out.println(climbStairs.climbStairs(25));
    }

    @Test
    public void testClimbStairs() throws Exception {
        int[] inputs = {1,2,3,4};

        int[] results = {1,2,3,5};

        for (int i = 0; i < results.length; i++) {
            ClimbStairs c = new ClimbStairs();
            int r = c.climbStairs(inputs[i]);
            System.out.println(r);
            assertEquals(results[i], r);
        }
    }
}
