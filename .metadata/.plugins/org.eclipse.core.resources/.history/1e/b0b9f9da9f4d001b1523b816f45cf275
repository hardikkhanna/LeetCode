/**
 * 
 */
package leetcode.array.problems;

import java.util.Scanner;

/**
 * @author NIPC-43
 *
 *         Date : Jan 3, 2021 Time : 1:59:04 PM
 */
public class FinalPricesWithSpecialDiscount {

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
		arr = finalPrices(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		sc.close();
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int[] finalPrices(int[] prices) {
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[i] >= prices[j]) {
					prices[i] = prices[i] - prices[j];
					break;
				}
			}
		}
		return prices;
	}

}
