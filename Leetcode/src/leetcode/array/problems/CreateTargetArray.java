/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         7:54:32 PM
 */
public class CreateTargetArray {

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
		int[] element = new int[n];
		for (int i = 0; i < n; i++) {
			element[i] = sc.nextInt();
		}
		array = createTargetArray(array, element);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		sc.close();

	}

	/**
	 * @param array
	 * @param element
	 * @return
	 */
	private static int[] createTargetArray(int[] nums, int[] index) {
		ArrayList<Integer> targetList = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {

			targetList.add(index[i], nums[i]);

		}

		return targetList.stream().mapToInt(e -> e.intValue()).toArray();
	}

}
