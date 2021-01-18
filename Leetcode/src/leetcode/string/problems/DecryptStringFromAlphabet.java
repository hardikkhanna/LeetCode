/**
 * 
 */
package leetcode.string.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 3, 2021 Time : 4:11:22 PM
 */
public class DecryptStringFromAlphabet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "10#11#12";
		str = freqAlphabets(str);
		System.out.println(str);

	}

	/**
	 * @param str
	 * @return
	 */
	private static String freqAlphabets(String s) {
		int n = s.length();
		String ans = "";
		for (int i = 0; i < n;) {
			if (i < n - 2 && s.charAt(i + 2) == '#') {
				int num = Integer.parseInt(s.substring(i, i + 2));
				ans += (char) (num + 96);
				i = i + 3;
				continue;
			}
			ans += (char) (97 + s.charAt(i) - '1');
			i++;
		}
		return ans;
	}

}
