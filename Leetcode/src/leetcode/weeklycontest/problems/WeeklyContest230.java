/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.Arrays;
import java.util.List;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : Feb 28, 2021 Time : 8:07:33 AM
 */
public class WeeklyContest230 extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] baseCost = get1DArray();
		int[] toppings = get1DArray();
		int target = 18;
		int cost = closestCost(baseCost, toppings, target);
		System.out.print(cost);

	}

	/**
	 * @param baseCost
	 * @param toppings
	 * @param target
	 * @return
	 */
	private static int closestCost(int[] baseCost, int[] toppings, int target) {
		int cost = 0;
		int closest = Integer.MAX_VALUE;
		int toppingsCost = 0;
		Arrays.sort(baseCost);
		for(int i =0;i<baseCost.length;i++) {
			toppingsCost = baseCost[i];
			for(int j =0;j<toppings.length;j++) {
				toppingsCost += toppings[j];
				if(toppingsCost > target) {
					toppingsCost -= toppings[j];
					break;
				}
			}
			if(target - toppingsCost < closest) {
				closest = target - toppingsCost;
				cost = toppingsCost;
			}
		}
		return cost;
	}

}
