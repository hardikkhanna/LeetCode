/**
 * 
 */
package leetcode.array.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 3, 2021 Time : 2:13:55 PM
 */
public class ReplaceWithGreatestOnRightSide {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		arr = replaceElements(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		sc.close();
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int[] replaceElements(int[] arr) {
		if(arr.length == 1) {
			arr[arr.length - 1] = -1;
			return arr;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[j] > max) {
					max = arr[j];
				}
				
			}
			arr[i] = max;
		}
		arr[arr.length - 1] = -1;
		return arr;
	}

}
