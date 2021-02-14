/**
 * 
 */
package leetcode.math.probems;

/**
 * @author Hardik
 *
 *         Date : Feb 3, 2021 Time : 11:02:16 AM
 */
public class HammingWeight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = hammingWeight(00000000000000000000000000001011);
		System.out.println(n);

	}

	/**
	 * @param valueOf
	 * @return
	 */
	private static int hammingWeight(int i) {
		return Integer.bitCount(Integer.valueOf(i));
	}

}
