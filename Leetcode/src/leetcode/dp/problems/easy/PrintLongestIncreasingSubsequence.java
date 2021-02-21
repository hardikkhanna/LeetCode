/**
 * 
 */
package leetcode.dp.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import leetcode.array.problems.ScannerInput;

/**
 * @author NIPC-43
 *
 *         Date : Feb 21, 2021 Time : 1:33:48 PM
 */
public class PrintLongestIncreasingSubsequence extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = get1DArray();
		List<Integer> LIS = getLIS(arr);
		System.out.println(LIS);

	}

	/**
	 * @param arr
	 * @return
	 */
	private static List<Integer> getLIS(int[] arr) {
		List<Integer> list = new ArrayList<>();
		List<Integer> longestList = new ArrayList<>();
		int currentMax;
		int highestCount = 0;
		for (int i = 0; i < arr.length; i++) {
			currentMax = Integer.MIN_VALUE;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] > currentMax) {
					list.add(arr[j]);
					currentMax = arr[j];
				}
			}
			if (highestCount < list.size()) {
				highestCount = list.size();
				longestList= new ArrayList<Integer>(list);
			}
			list.clear();
		}
		return longestList;
	}

}
