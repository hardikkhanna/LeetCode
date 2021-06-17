/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 13-Apr-2021 Time : 12:09:43 pm
 */
public class CreateSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			long n = sc.nextLong();
			long[] arr = printSequence(n);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
		}
		sc.close();
	}

	private static long[] printSequence(long n) {
		List<Long> list = new ArrayList<Long>();
		getPermutations(n,(long) 0,list);
		//getPermutations(n,5,list);
		return list.stream().mapToLong(value -> value).toArray();
	}

	/**
	 * @param range
	 * @param N
	 * @param list
	 */
	private static void getPermutations(long range, Long value, List<Long> list) {
		if(value > range) return;
		if(value * 10 + 2 <= range) list.add((long) (value * 10 + 2));
		if(value* 10 + 5 <= range) list.add((long) (value * 10 + 5));
		getPermutations(range, value * 10 + 2, list);
		getPermutations(range, value * 10 + 5, list);
	}

}
