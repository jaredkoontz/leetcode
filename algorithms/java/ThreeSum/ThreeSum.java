package ThreeSum;

// Source : https://oj.leetcode.com/problems/3sum/
// Author : Hao Chen & jared
// Date   : 2014-07-22 / 10-23-15

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**********************************************************************************
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *
 * For example, given array S = {-1 0 1 2 -1 -4},
 *
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 **********************************************************************************/
public class ThreeSum {

    /*
    The idea is to sort an input array and then run through all indices of a possible first element of a triplet.
    For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array.
    Also we want to skip equal elements to avoid duplicates in the answer without making a set or something like that.
    */

	/*
 *   Simlar like "Two Number" problem, we can have the simlar solution.
 *
 *   Suppose the input array is S[0..n-1], 3SUM can be solved in O(n^2) time on average by
 *   inserting each number S[i] into a hash table, and then for each index i and j,
 *   checking whether the hash table contains the integer - (s[i]+s[j])
 *
 *   Alternatively, the algorithm below first sorts the input array and then tests all
 *   possible pairs in a careful order that avoids the need to binary search for the pairs
 *   in the sorted list, achieving worst-case O(n^n)
 *
 *   Solution:  Quadratic algorithm
 *   http://en.wikipedia.org/wiki/3SUM
 *
 */
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
				while (lo < hi) {
					if (num[lo] + num[hi] == sum) {
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						while (lo < hi && num[lo] == num[lo + 1]) lo++;
						while (lo < hi && num[hi] == num[hi - 1]) hi--;
						lo++;
						hi--;
					} else if (num[lo] + num[hi] < sum) lo++;
					else hi--;
				}
			}
		}
		return res;
	}

}
