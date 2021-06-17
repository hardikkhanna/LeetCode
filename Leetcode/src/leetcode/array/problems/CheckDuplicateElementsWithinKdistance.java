/**
 * 
 */
package leetcode.array.problems;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 20-May-2021 Time : 10:26:02 am
 */
public class CheckDuplicateElementsWithinKdistance extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = get1DArray();
		int k = sc.nextInt();
		Boolean ans = checkDuplicate(arr, arr.length, k);
		System.out.println(ans);
		sc.close();

	}

	/**
	 * @param arr
	 * @return
	 */
	private static Boolean checkDuplicate(int[] arr, int N, int K) {
		if (arr == null || arr.length == 0)
			return false;

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < K + 1; i++) {
			if (map.containsKey(arr[i]))
				return true;
			map.put(arr[i], 1);
		}
		int j = K + 1;
		int start = 0;
		for (int i = 1; i < N && j < N; i++) {
			if (arr[i] == -31) {
				System.out.println("Reached");
			}
			map.remove(arr[start]);
			if (map.containsKey(arr[j++]))
				return true;
			map.put(arr[i], 1);
			start++;
		}
		return false;
	}

}
