/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 20-May-2021 Time : 9:56:08 am
 */
public class CountDistinctElementInEveryKWindow extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			arr.add(sc.nextInt());

		ArrayList<Integer> ans = countDistinctElements(arr, k);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param arr
	 * @return
	 */
	private static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
		if (arr == null || arr.size() == 0)
			return null;

		ArrayList<Integer> ans = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < k; i++) {
			map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
		}
		ans.add(map.size());
		int start = 0;
		for (int i = k; i < arr.size(); i++) {

			if (map.get(arr.get(start)) == 1)
				map.remove(arr.get(start));
			else
				map.put(arr.get(start), map.get(arr.get(start)) - 1);

			int val = map.containsKey(arr.get(i)) ? map.get(arr.get(i)) : 0;
			map.put(arr.get(i), val + 1);
			ans.add(map.size());
			start++;
		}
		return ans;
	}

}
