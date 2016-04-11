package longestCommonPrefix;

//todo
public class longestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String currentLongest = strs[0];
		for (int i = 1; i < strs.length; i++) {
			String next = strs[i];
			while (next.indexOf(currentLongest) != 0)
				currentLongest = currentLongest.substring(0, currentLongest.length() - 1);
		}
		return currentLongest;
	}
}
