package twoSumClass;

// Source : https://oj.leetcode.com/problems/two-sum-iii-data-structure-design/
// Author : Hao Chen / Jared Koontz
// Date   : 2014-06-17 / 10/23/15


import java.util.HashMap;
import java.util.Map;

/**********************************************************************************
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * <p/>
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * <p/>
 * For example,
 * <p/>
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 **********************************************************************************/

class TwoSumClass {
	private HashMap<Integer, Integer> nums = new HashMap<>();

	//O(1) add
	void add(int number) {
		if (nums.get(number) == null)
			nums.put(number, 1);
		else
			nums.put(number, nums.get(number) + 1);
	}

	//O(n) find
	boolean find(int value) {
		int one, two;
		for (Map.Entry<Integer, Integer> entry : nums.entrySet()) {
			one = entry.getKey();
			two = value - one;
			if ((one == two && entry.getValue() > 1) || (one != two && nums.get(two) != null))
				return true;
		}
		return false;
	}

	private void run() {
		add(1);
		add(3);
		add(5);
		System.out.println(find(4)); // -> true
		System.out.println(find(7)); // -> false
	}

	public static void main(String[] a) {
		TwoSumClass s = new TwoSumClass();
		s.run();
	}

}
