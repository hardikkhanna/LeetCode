/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author NIPC-43
 *
 *         Date : Jan 31, 2021 Time : 4:20:43 PM
 */
public class FindCommonCharacters extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] A = new String[n];
		for (int i = 0; i < n; i++) {
			A[i] = sc.next();
		}
		List<String> ans = commonChars(A);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		sc.close();
	}

	/**
	 * @param a
	 * @return
	 */
	private static List<String> commonChars(String[] A) {
		int[] count = new int[26];
		Arrays.fill(count, Integer.MAX_VALUE);
		for (String str : A) {
			int[] cnt = new int[26];
			str.chars().forEach(c -> ++cnt[c - 'a']); // count each char's frequency in string str.
			IntStream.range(0, 26).forEach(i -> count[i] = Math.min(cnt[i], count[i])); // update minimum frequency.
		}
		List<String> ans = new ArrayList<>();
		IntStream.range('a', 'z' + 1).forEach(c -> ans.addAll(Collections.nCopies(count[c - 'a'], "" + (char) c)));
		return ans;
	}

}
