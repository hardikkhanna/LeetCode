/**
 * 
 */
package leetcode.sort.problems;

import java.util.Arrays;
import java.util.Scanner;

import leetcode.array.problems.ScannerInput;

/**
 * @author NIPC-43
 *
 *         Date : Jan 17, 2021 Time : 8:49:08 PM
 */
public class MaximumUnitsOnTruck extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] boxTypes = get2DArray();
		int truckSize = sc.nextInt();
		int ans = maximumUnits(boxTypes, truckSize);
		System.out.println(ans);
		sc.close();

	}

	/**
	 * @param boxTypes
	 * @param truckSize
	 * @return
	 */
	private static int maximumUnits(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, (a, b) -> -Integer.compare(a[1], b[1]));
		int ans = 0;
		int remboxes = 0;
		for (int[] arr : boxTypes) {
			if (arr[0] < truckSize) {
				if (remboxes + arr[0] <= truckSize) {
					ans += arr[1] * arr[0];
				} else {
					ans += arr[1] * (truckSize - remboxes);
					break;
				}
				remboxes += arr[0];
			}
		}
		return ans;
	}

}
