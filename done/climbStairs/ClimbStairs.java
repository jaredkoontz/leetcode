package climbStairs;

// Source : https://oj.leetcode.com/problems/climbing-stairs/
// Author : Hao Chen & Jared Koontz
// Date   : 2014-06-27 / 10/23/15

/**********************************************************************************
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 **********************************************************************************/

public class ClimbStairs {

    /*
    The problem seems to be a dynamic programming one. Hint: the tag also suggests that! Here are the steps to get the solution incrementally.

    Base cases:
            if n <= 0, then the number of ways should be zero. if n == 1, then there is only way to climb the stair. if n == 2, then there are two ways to climb the stairs. One solution is one step by another; the other one is two steps at one time.

    The key intuition to solve the problem is that given a number of stairs n, if we know the number ways to get to the points [n-1] and [n-2] respectively, denoted as n1 and n2 , then the total ways to get to the point [n] is n1 + n2. Because from the [n-1] point, we can take one single step to reach [n]. And from the [n-2] point, we could take two steps to get there. There is NO overlapping between these two solution sets, because we differ in the final step.

    Now given the above intuition, one can construct an array where each node stores the solution for each number n. Or if we look at it closer, it is clear that this is basically a fibonacci number, with the starting numbers as 1 and 2, instead of 1 and 1.

    The implementation in Java as follows:
    */

    public int climbStairs(int n) {
        int[] matrix = new int[n];
        if (n < 3) {
            return n;
        }
        matrix[0] = 1;
        matrix[1] = 2;
        // write your code here
        for (int i = 2; i < matrix.length; i++) {
            matrix[i] = matrix[i-1] + matrix[i-2];
        }
        return matrix[n-1];
    }

    int climbStairs2(int n) {
        if (n<=3) return n;
        int a[] = new int[]{2,3};
        for(int i=4; i<=n; i++){
            int t = a[0] + a[1];
            a[0] = a[1];
            a[1] = t;
        }
        return a[1];
    }

    //Time too long
    int climbStairsFoolish(int n) {
        if (n<=3) return n;
        return climbStairsFoolish(n - 1) + climbStairsFoolish(n - 2);
    }
}
