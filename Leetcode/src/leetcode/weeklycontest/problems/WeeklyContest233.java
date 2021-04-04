/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.HashMap;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : Mar 21, 2021 Time : 8:25:41 AM
 */
public class WeeklyContest233 extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] orders = get2DArray();
		int res = getNumberOfBacklogOrders(orders);
		System.out.println(res);
	}

	/**
	 * @param orders
	 * @return
	 */
	private static int getNumberOfBacklogOrders(int[][] orders) {
		HashMap<Integer, Integer> buyMap = new HashMap<>();
		HashMap<Integer, Integer> sellMap = new HashMap<>();
		if (orders.length == 0)
			return 0;
		for (int i = 0; i < orders.length; i++) {
			int price = orders[i][0];
			int amount = orders[i][1];
			int orderType = orders[i][2];
			if (orderType == 1) {

			} else {
				if (!sellMap.isEmpty()) {
					sellMap.entrySet().removeIf(e -> e.getValue() <= amount);
				} else {
					buyMap.put(amount, price);
				}
			}
		}
		return 0;
	}

}
