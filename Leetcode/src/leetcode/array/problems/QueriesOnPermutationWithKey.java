/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hardik
 *
 *         Date : Jan 8, 2021 Time : 7:21:39 AM
 */
public class QueriesOnPermutationWithKey extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] queries = get1DArray();
		int m = sc.nextInt();
		queries = processQueries(queries, m);
		for (int i : queries) {
			System.out.print(queries[i] + " ");
		}

	}

	/**
	 * @param queries
	 * @param m
	 * @return
	 */
	private static int[] processQueries(int[] queries, int m) {
		List<Integer> list = new ArrayList<Integer>();
		int i = 1;
		while (m-- > 0) {
			list.add(i++);
		}
		for (int j = 0; j < queries.length; j++) {
			int n = queries[j];
			queries[j] = list.indexOf(queries[j]);
			list.remove(queries[j]);
			list.add(0, n);
		}
		return queries;
	}

}
