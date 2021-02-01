/**
 * 
 */
package leetcode.string.problems;

/**
 * @author NIPC-43
 *
 *         Date : Jan 31, 2021 Time : 6:35:48 PM
 */
public class MinimumShiftsRequired {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = "jfdhgfdhgghfdhg";
		String b = "erywtroueytoretiroeurieyritretopreithwiteriutrjuutieuyit";
		int ans = minimumRequiredShifts(a, b);
		System.out.println(ans);
	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	private static int minimumRequiredShifts(String a, String b) {
		if (a.equalsIgnoreCase(b))
			return 0;
		int index = 0;
		int maxLength = Integer.MIN_VALUE;
		for (int j = 0; j < a.length(); j++) {
			String s = a.substring(0, j + 1);
			if (b.contains(s) && s.length() > maxLength) {
				index = b.indexOf(s);
				maxLength = s.length();
			}
		}
		return index;
	}

}
