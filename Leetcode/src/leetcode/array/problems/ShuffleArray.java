/**
 * 
 */
package leetcode.array.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         4:11:30 PM
 */
public class ShuffleArray {

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
		int num = sc.nextInt();
		array = shuffle(array, num);
		Arrays.stream(array).forEach(i -> System.out.print(i + " "));
		sc.close();
	}

	/**
	 * @param array
	 * @param num
	 * @return
	 */
	private static int[] shuffle(int[] array, int num) {
		int[] ans = new int[array.length];
		int mid = array.length / 2;
		for (int i = 0; i < array.length / 2; i++) {
			ans[2 * i] = array[i];
			ans[2 * i + 1] = array[mid + i];
		}
		return ans;
	}

}
