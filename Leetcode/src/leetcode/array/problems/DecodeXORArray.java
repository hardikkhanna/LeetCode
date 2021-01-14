/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 10, 2021 Time : 8:25:26 AM
 */
public class DecodeXORArray extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] encoded = get1DArray();
		int first = sc.nextInt();
		encoded = decode(encoded, first);
		for (int i = 0; i < encoded.length; i++) {
			System.out.print(encoded[i] + " ");
		}

	}

	/**
	 * @param encoded
	 * @param first
	 * @return
	 */
	private static int[] decode(int[] encoded, int first) {
		int[] ans = new int[encoded.length + 1];
		ans[0] = first;
		for (int i = 0; i < encoded.length; i++) {
			ans[i + 1] = encoded[i] ^ ans[i];
		}
		return ans;
	}

}
