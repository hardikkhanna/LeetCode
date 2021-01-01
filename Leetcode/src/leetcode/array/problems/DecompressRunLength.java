/**
 * 
 */
package leetcode.array.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         7:43:43 PM
 */
public class DecompressRunLength {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		array = decompressRLElist(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		sc.close();
	}

	/**
	 * @param array
	 * @return
	 */
	private static int[] decompressRLElist(int[] nums) {
		int len = 0;
		for (int i = 0; i < nums.length; i += 2) {
			len += nums[i];
		}
		int[] res = new int[len];
		int ind = 0;
		for (int i = 0; i < nums.length; i += 2) {
			Arrays.fill(res, ind, ind + nums[i], nums[i + 1]);
			ind = ind + nums[i];
		}
		return res;
	}

}
