package wildcardMatching;

//todo
public class wildcardMatching {
    /*The basic idea is to check and advance two pointers in two strings correspondingly if satisfying specific
    condition. And the trick part is the attempting backtracking method for '*' matching, which can be checked out in
    the code. Thanks for this great idea from Yu and pandora.*/

	public static void main(String[] a) {
		wildcardMatching m = new wildcardMatching();
		m.run();

	}

	public boolean isMatch1(String str, String pattern) {
		int s = 0, p = 0, pStar = -1, sMatchStar = 0; // s is the pointer index of str; p is the pointer index of pattern.
		while (s < str.length()) {
			// Advancing both pointers: if current pointer of pattern is '?', or current two pointers sMatchStar
			if (p < pattern.length() && (pattern.charAt(p) == '?' || pattern.charAt(p) == str.charAt(s))) {
				s++;
				p++;
			} else if (p < pattern.length() && pattern.charAt(p) == '*') {
				// Only advancing pattern pointer, and track index of '*': if current pointer of pattern is '*'
				pStar = p;
				sMatchStar = s;
				p++;
			} else if (pStar != -1) {// Only advancing string pattern : if last pattern was '*'
				p = pStar + 1;  // If current characters didn't match, try to backtrack p to '*' + 1
				sMatchStar++;
				s = sMatchStar; // Backtrack s to last index matching '*' + 1
			}
			// Characters didn't sMatchStar: 1) Current two pointers didn't sMatchStar; 2) No '?' found; 3) No '*' found.
			else return false;
		}

		// Check the remaining characters in pattern: only advancing with '*'
		while (p < pattern.length() && pattern.charAt(p) == '*')
			p++;
		// Characters only sMatchStar if the pattern reaches its end.
		return p == pattern.length();
	}

	private void run() {
		System.out.println(isMatch1("aa", "a")); // ? false
		System.out.println(isMatch1("aa", "aa")); // ? true
		System.out.println(isMatch1("aaa", "aa")); // ? false
		System.out.println(isMatch1("aa", "*")); // ? true
		System.out.println(isMatch1("aa", "a*")); // ? true
		System.out.println(isMatch1("ab", "?*")); // ? true
		System.out.println(isMatch1("aab", "c*a*b")); // ? false
	}
}
