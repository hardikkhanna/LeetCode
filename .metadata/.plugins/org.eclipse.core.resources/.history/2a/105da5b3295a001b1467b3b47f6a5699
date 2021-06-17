/**
 * 
 */
package leetcode.string.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 17, 2021 Time : 2:26:44 PM
 */
public class CharactersThatHaveOddCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 2;
		String str = generateTheString(n);
		System.out.println(str);

	}

	/**
	 * @param n
	 * @return
	 */
	private static String generateTheString(int m) {
		String str = "";
		for (int i = 0; i < m; i++)
			str += "a";
		if (str.length() % 2 == 0)
			str = "b" + str.substring(1);
		return str;
	}

}
