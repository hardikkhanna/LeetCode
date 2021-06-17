/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : 08-May-2021 Time : 9:12:34 pm
 */
public class SuperPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SuperPalindrome pal = new SuperPalindrome();
//		int left = 4;
//		int right = 100;
		int count = pal.superpalindromesInRange("4", "1000");
		System.out.println(count);
	}

	public int superpalindromesInRange(String left, String right) {
		int count = 0;
		long start = Long.valueOf(left);
		long end = Long.valueOf(right);
		for (long i = start; i <= end; i++) {
			// if(i == 4 || i == 9 || i == 121) {
			// System.out.println("Reached");
			// }
			if (isPalindrome(i) && (checkPerfectSquare(i)) && isPalindrome((int) Math.sqrt(i))) {
				// if()
				// System.out.println(i * i);
				count++;

			}

		}
		return count;
	}

	private boolean checkPerfectSquare(long n) {
		return Math.ceil((double) Math.sqrt(n)) == Math.floor((double) Math.sqrt(n));
	}

	private boolean isPalindrome(long num) {
		String str = String.valueOf(num);
		int start = 0;
		int end = str.length() - 1;
		while (start <= end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}
