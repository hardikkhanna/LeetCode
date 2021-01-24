/**
 * 
 */
package leetcode.string.problems;

/**
 * @author NIPC-43
 *
 *         Date : Jan 24, 2021 Time : 8:16:09 AM
 */
public class LatestTimeByReplacingHiddenDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "?0:??";
		str = maximumTime(str);
		System.out.println(str);

	}

	/**
	 * @param str
	 * @return
	 */
	private static String maximumTime(String str) {
		if (str == null)
			return "";
		if (str.charAt(0) == '?' && str.charAt(1) == '?')
			str = "23" + str.substring(str.indexOf(":"));
		if (str.charAt(0) == '?'
				&& (str.charAt(1) == '0' || str.charAt(1) == '1' || str.charAt(1) == '2' || str.charAt(1) == '3'))
			str = '2' + str.substring(0 + 1);
		if (str.charAt(0) == '?')
			str = '1' + str.substring(0 + 1);

		if (str.charAt(1) == '?' && str.charAt(0) == '2')
			str = str.charAt(0) + "3" + str.substring(2);
		if (str.charAt(1) == '?' && str.charAt(0) != '2')
			str = str.charAt(0) + "9" + str.substring(2);
		if (str.charAt(3) == '?' && str.charAt(4) == '?')
			str = str.substring(0, str.indexOf(":") + 1) + "59";
		if (str.charAt(3) == '?')
			str = str.substring(0, 3) + "5" + str.substring(3 + 1);
		if (str.charAt(4) == '?')
			str = str.substring(0, 4) + "9" + str.substring(4 + 1);
		return str;
	}

}
