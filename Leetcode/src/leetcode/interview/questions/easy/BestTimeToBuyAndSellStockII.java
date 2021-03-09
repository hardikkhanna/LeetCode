/**
 * 
 */
package leetcode.interview.questions.easy;

import leetcode.array.problems.ScannerInput;

/**
 * @author NIPC-43
 *
 *         Date : Mar 8, 2021 Time : 5:01:18 PM
 */

/*
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * Find the maximum profit you can achieve. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times).
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockII extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = get1DArray();
		int profit = maxProfit(prices);
		System.out.println(profit);
	}

	/**
	 * @param prices
	 * @return
	 */
	private static int maxProfit(int[] prices) {
		// TODO Auto-generated method stub
		return 0;
	}

}
