package palindromeNumber;

//todo
public class palindromeNumber {
	public boolean isPalindrome(int x) {

		if (x < 0) return false;

		int p = x;
		int q = 0;

		while (p >= 10) {
			q *= 10;
			q += p % 10;
			p /= 10;
		}

		return q == x / 10 && p == x % 10;
	}
}
