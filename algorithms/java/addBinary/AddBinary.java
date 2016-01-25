package addBinary;

// Source : https://oj.leetcode.com/problems/add-binary/
// Author : Hao Chen & Jared Koontz
// Date   : 2014-07-05 / 10-23-2015

/**********************************************************************************
 * Given two binary Strings, return their sum (also a binary String).
 *
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 **********************************************************************************/

public class AddBinary {

	String addBinary(String a, String b) {
		if (a == null || a.isEmpty())
			return b;
		if (b == null || b.isEmpty())
			return a;


		StringBuilder stb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int aBit;
		int bBit;
		int carry = 0;
		int result;

		while (i >= 0 || j >= 0 || carry == 1) {
			aBit = (i >= 0) ? Character.getNumericValue(a.charAt(i--)) : 0;
			bBit = (j >= 0) ? Character.getNumericValue(b.charAt(j--)) : 0;
			result = aBit ^ bBit ^ carry;
			carry = ((aBit + bBit + carry) >= 2) ? 1 : 0;
			stb.append(result);
		}
		return stb.reverse().toString();
	}

}
