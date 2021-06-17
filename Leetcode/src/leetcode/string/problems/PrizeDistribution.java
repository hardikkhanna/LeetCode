/**
 * 
 */
package leetcode.string.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author NIPC-57
 *
 *         Date : 12-Jun-2021 Time : 3:59:36 pm
 */
public class PrizeDistribution {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}
		int k = sc.nextInt();
		int ans = numOfPrizes(k, list);
		System.out.println(ans);
	}

	/**
	 * @param k
	 * @param list
	 * @return
	 */
	private static int numOfPrizes(int k, List<Integer> list) {
		int ans = 0;
		Collections.sort(list, Collections.reverseOrder());
		int j = 1;
		return ans;
	}

}
