/**
 * 
 */
package leetcode.string.problems;

/**
 * @author NIPC-43
 *
 *         Date : Jan 18, 2021 Time : 11:24:32 PM
 */
public class ReverseWordsInStringIII {

	public static void main(String[] args) {
		String str = "";
		str = reverseString(str);
		System.out.println(str);
	}

	/**
	 * @param str
	 * @return
	 */
	private static String reverseString(String s) {
		String ans = "";
		String[] arr = s.split(" ");
		for (String str : arr) {
			StringBuilder word = new StringBuilder(str);
			ans += word.reverse() + " ";
		}
		return ans.trim();
	}

}
