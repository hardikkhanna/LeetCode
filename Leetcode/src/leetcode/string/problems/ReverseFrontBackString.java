/**
 * 
 */
package leetcode.string.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 20, 2021 Time : 10:07:31 PM
 */
public class ReverseFrontBackString {

	public static void main(String[] args) {
		String str = "the big cat jumped over the lazy dog";
		String ans = reverse(str.split(" "));
		System.out.println(ans);

	}

	private static String reverse(String[] strings) {
		int k = strings.length - 1;
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < strings.length / 2; i++) {
			ans.append(new StringBuilder(strings[k] + " ").reverse().toString())
					.append(new StringBuilder(strings[i] + " ").reverse().toString());
			k--;
		}
		return strings.length % 2 != 0 ? ans.append(" " + strings[strings.length / 2]).toString().trim()
				: ans.toString().trim();
	}

}
